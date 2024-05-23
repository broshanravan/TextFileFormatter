package com.fruugo;

import com.fruugo.inputProcessors.UserInputProcessor;
import com.fruugo.inputProcessors.UserInputProcessorImpl;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter 'stop' to exit the app or enter the file name to begin");
        Scanner input = new Scanner(System.in);
        String fileName = "";

        UserInputProcessor userInputProcessor = new UserInputProcessorImpl();
        while (!"stop".equalsIgnoreCase(fileName)) {
            userInputProcessor.startConverting();
            System.out.println("Enter 'stop' to exit the app or tap 'Enter' button to start again");
            fileName = input.nextLine();
        }


    }


}
