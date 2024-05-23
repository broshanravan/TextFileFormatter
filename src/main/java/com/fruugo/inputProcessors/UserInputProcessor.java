package com.fruugo.inputProcessors;

public interface UserInputProcessor {

    public boolean fileExists(String inputFileName);

    public void saveFinalString(String inputfileName, String convertedFinalContent);

    public void startConverting();
}
