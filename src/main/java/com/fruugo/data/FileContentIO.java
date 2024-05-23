package com.fruugo.data;

public interface FileContentIO {
    public String readInputFileContents(String filenamePath);
    public void creatOutputFile( String outputFileName,String inputFileContent);
}
