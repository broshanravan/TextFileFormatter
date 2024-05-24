package com.fruugo.service;

import com.fruugo.enums.ConversionType;

public interface FileContentConvertor {

    public String reverseContents(String fileContents);
    public String removeWhiteSpaces(String fileContents);
    public String getAsciiCode(String fileContent);
    public String convertSeventhCharToE(String fileContents);

}
