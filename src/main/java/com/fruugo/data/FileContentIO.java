package com.fruugo.data;

import com.fruugo.service.FileContentConvertorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Manages reading from source file
 * and writing into the destination
 * File
 */

public class FileContentIO {


    private static Logger logger = LogManager.getLogger(FileContentConvertorImpl.class);
    /**
     * reads the contents of the input file
     * and returns it for formatting
     * @param filenamePath
     * @return
     */
    public String readInputFileContents(String filenamePath) {

        BufferedReader reader;
        StringBuffer fileContentsBuffer = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(filenamePath));
            String line = reader.readLine();
            while (line != null) {
                fileContentsBuffer.append(line);
                fileContentsBuffer.append("\n");
                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String contents = fileContentsBuffer.toString();
        return fileContentsBuffer.toString();
    }

    /**
     * saves the final text into the
     * output file
     * @param outputFileName
     * @param inputFileContent
     */
    public void creatOutputFile( String outputFileName,String inputFileContent) {
        //Todo The hardcoded string 'output' should eventualy be read from properties file as it already exists there
        String fileName = ".\\output\\" + outputFileName;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(inputFileContent);

            writer.close();
        } catch (IOException ex) {
            System.out.print("Invalid Path");
        }


    }
}
