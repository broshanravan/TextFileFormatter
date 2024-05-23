package com.fruugo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * provides functionality for
 * formatting file contents
 */
public class FileContentConvertorImpl  implements FileContentConvertor{

    private static Logger logger = LogManager.getLogger(FileContentConvertorImpl.class);

    /**
     * reverses the contents of each
     * line in the test file
     * @param lineContents
     * @return
     */
    public String reverseContents(String lineContents) {
        if(lineContents != null) {
            return new StringBuffer(lineContents).reverse().toString();
        }
        return "";
    }

    /**
     * Removes all the while spaces
     * in all lines of the text file content
     * @param fileContentLine
     * @return
     */
    public String removeWhiteSpaces(String fileContentLine) {
        return fileContentLine.replaceAll("\\s", "");
    }

    /**
     * returns the ASCII code of the values
     * within the text file
     * @param fileContentLine
     * @return
     */
    public String getAsciiCode(String fileContentLine){
        Stream<Character>  charactersStream = fileContentLine.chars().mapToObj(i -> (char)i);

        AtomicReference<String> asciiConvertedTxt = new AtomicReference<>("");
        charactersStream.map(c -> {
            int asci = getAscii(c) ;
            if (asci > 32 && asci < 63) {
                return asci + 1;
            } else {
                return c;
            }
        }).forEach(c -> asciiConvertedTxt.updateAndGet(v -> v + c));
        return asciiConvertedTxt.get();
    }


    /**
     * converts the seventh character of each
     * line(if it exists) to the character:
     * 'e'
     * @param fileContentLine
     * @return
     */
    public String convertSeventhCharToE(String fileContentLine) {
        if (fileContentLine.length() >= 7) {
            fileContentLine = fileContentLine.substring(0, 6) + "e" + fileContentLine.substring(7);
        }
        return fileContentLine;
    }

    /**
     * Converts a character into its
     * ASCII Code
     * @param character
     * @return
     */
    private int getAscii(char character){
        return character;
    }


}
