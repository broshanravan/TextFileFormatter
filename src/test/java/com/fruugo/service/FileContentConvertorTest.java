package com.fruugo.service;

import org.junit.Test;

public class FileContentConvertorTest {

    FileContentConvertor fileContentConvertor = new FileContentConvertorImpl();

    @Test
    public void reverseContentsTest(){
        String revertText = fileContentConvertor.reverseContents("ABCD");
        assert("DCBA".equals(revertText)) ;

    }

    @Test
    public void removeWhiteSpacesTest() {
        String noWhiteSpacesText = fileContentConvertor.removeWhiteSpaces("There should be no white spaces here");
        assert ("Thereshouldbenowhitespaceshere".equals(noWhiteSpacesText));

    }

    @Test
    public void getAsciiCodeTest(){
        String convertedString = fileContentConvertor.getAsciiCode("Onl&y!*0");
        assert(convertedString.equalsIgnoreCase("Onl39y344349"));
    }

    @Test
    public void getAsciiCodeTestBorder(){
        String convertedString = fileContentConvertor.getAsciiCode("@Onl&y! * 0");
        assert(convertedString.equalsIgnoreCase("65Onl39y3433433349"));
    }


    @Test
    public void convertSeventhCharToCShorterThanSevenTest(){
        String convertedString = fileContentConvertor.convertSeventhCharToE("Only 6");
        assert ("Only 6".equals(convertedString));

    }
    @Test
    public void convertSeventhCharToCLongerOrEqualToSevenTest(){
        String convertedString = fileContentConvertor.convertSeventhCharToE("Longer or equal to seven");
        assert ("Longereor equal to seven".equals(convertedString));
    }

    @Test
    public void convertAllSevenCharactersToETest() {
        String convertedString = fileContentConvertor.convertAllSevenCharactersToE("All charact7rs of valu7 s7v7n");
        assert ("All characters of value seven".equals(convertedString));
    }

    @Test
    public void convertAllSevenCharactersToENoDevenTest() {
        String convertedString = fileContentConvertor.convertAllSevenCharactersToE("123456 All characters of value seven890");
        assert ("123456 All characters of value seven890".equals(convertedString));
    }


}
