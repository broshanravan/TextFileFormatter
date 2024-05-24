package com.fruugo.inputProcessors;

import com.fruugo.data.FileContentIO;
import com.fruugo.data.FileContentIOImpl;
import com.fruugo.enums.ConversionType;
import com.fruugo.service.FileContentConvertor;
import com.fruugo.service.FileContentConvertorImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Initialize the user input
 * panel and processes the data
 * entered by the user
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInputProcessorImpl implements UserInputProcessor {

    private static Logger logger = LogManager.getLogger(FileContentConvertorImpl.class);
    String fileNameTale ="";
    FileContentConvertor fileContentConvertor= new FileContentConvertorImpl();
    FileContentIO fileContentIOImpl = new FileContentIOImpl();

    /**
     * constructing the dynamic
     * part of file name on
     * each file content conversion
     * @param conversionType
     */
    private void constructFleNameTale(ConversionType conversionType){
        String conversionTypeValue = conversionType.getValue();
        if("REV".equalsIgnoreCase(conversionTypeValue)){
            fileNameTale += "-1";
        } else if("SEV".equalsIgnoreCase(conversionTypeValue)){
            fileNameTale += "-2";
        }else if("TRM".equalsIgnoreCase(conversionTypeValue)){
            fileNameTale += "-3";
        }else if("ASC".equalsIgnoreCase(conversionTypeValue)){
            fileNameTale += "-4";
        }
        //System.out.println("fileNameTale  in construction= " + fileNameTale);

    }



    /**
     * It will format the contents of
     *  provided file into consecutive
     *  format types until the user exits
     * @param fileContents
     * @param conversionType
     * @return
     */
    public String getConvertedContent(String fileContents, ConversionType conversionType) {
        BufferedReader fileContentsBufferReader = new BufferedReader(new StringReader(fileContents));
        String convertedContents = "";

        try {
            String line = "";

            while ((line = fileContentsBufferReader.readLine()) != null) {
                if (conversionType.equals(ConversionType.SEV)) {
                    line = fileContentConvertor.convertAllSevenCharactersToE(line);
                } else if (conversionType.equals(ConversionType.REV)) {
                    line = fileContentConvertor.reverseContents(line);
                } else if (conversionType.equals(ConversionType.TRM)) {
                    line = fileContentConvertor.removeWhiteSpaces(line);
                } else if (conversionType.equals(ConversionType.ASC)) {
                    line = fileContentConvertor.getAsciiCode(line);
                }

                if (line.trim().length() == 0) {
                    if (!conversionType.equals(ConversionType.TRM)) {
                        convertedContents += line;
                        convertedContents += "\n";
                    }

                } else {
                    convertedContents += line;
                    convertedContents += "\n";
                }
            }

        } catch (IOException ioe){
            logger.error(ioe.getMessage());

        }

        return convertedContents;
    }



    /**
     * creating the new output file name
     * and saving the contents to it
     * @param inputFileName
     * @param convertedFinalContent
     */
    public void saveFinalString(String inputFileName, String convertedFinalContent){
        String filename = "output" + fileNameTale + ".txt";
        fileContentIOImpl.creatOutputFile(filename,convertedFinalContent);
        fileNameTale = "";
    }


    /**
     * checks if the file name provided
     * is valid and the file exists
     * @param inputFileName
     * @return
     */
    public boolean fileExists(String inputFileName){
        boolean fileExists = false;
        File inputFile = new File(inputFileName);
        fileExists = inputFile.exists() && !inputFile.isDirectory();

        return fileExists;
    }

    /**
     * Initializing the user interface
     */
    public void startConverting(){

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String filenamePath = "./input/" + fileName;
        String fileContent = this.getFileContent(fileName);

        String message = "Please enter the conversion Type ('REV'.'SEV','TRM','ASC','COMP')";
        System.out.println(message);
        String conversionTypeValueInput = scanner.nextLine();

        int sequence = 0;
        try {
            ConversionType conversionType = ConversionType.valueOf(conversionTypeValueInput);
            constructFleNameTale(conversionType);
            fileContent = collectUserEntry(conversionType,   sequence,  fileContent);
        } catch (IllegalArgumentException iao) {
            System.out.println("Not a valid Type, try Again");
            conversionTypeValueInput = scanner.nextLine();
            ConversionType conversionType = ConversionType.valueOf(conversionTypeValueInput);
            fileContent = collectUserEntry( conversionType,   sequence,  fileContent);
            constructFleNameTale(conversionType);

        }
        saveFinalString(fileName, fileContent);
        System.out.println("***********************************");
        System.out.println("final file contents are:");
        System.out.println(fileContent);
        System.out.println("***********************************");

    }

    /**
     * processes the data input
     * from the user for validity
     * submits the text in the file for relevant
     * transition
     * @param conversionType
     * @param sequence
     * @param fileContent
     * @throws IllegalArgumentException
     */
    private String collectUserEntry(ConversionType conversionType, int  sequence, String fileContent) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        while(!conversionType.equals(ConversionType.COMP) && sequence < 20) {
            System.out.println("Please enter the next conversion Type ('REV'.'SEV','TRM','ASC','COMP')");
            fileContent = getConvertedContent(fileContent, conversionType);
            String conversionTypeInputValue = scanner.nextLine();
            conversionType = ConversionType.valueOf(conversionTypeInputValue);
            this.constructFleNameTale(conversionType);
            sequence ++;

        }
        return fileContent;
    }

    private String getFileContent(String fileName){
        //System.out.println("enter the file name to begin");
        Scanner scanner = new Scanner(System.in);
        //String fileName = scanner.nextLine();
        String filenamePath = "./input/" + fileName;
        File inputFile = new File(filenamePath);
        while(!fileExists(filenamePath)) {
            System.out.println("File does not exist. Please try again");
            filenamePath = "./input/" + scanner.nextLine();
            inputFile = new File(filenamePath);
        }

        return fileContentIOImpl.readInputFileContents(filenamePath);


    }

}
