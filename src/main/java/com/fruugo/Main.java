package com.fruugo;

import com.fruugo.inputProcessors.UserInputProcessor;
import com.fruugo.inputProcessors.UserInputProcessorImpl;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInputProcessor userInputProcessor = new UserInputProcessorImpl();
        boolean running = false;
        Scanner input = new Scanner(System.in);
        String fileName = "";
        while(!"stop".equalsIgnoreCase(fileName)){
            if(!running) {
                System.out.println("Enter 'stop' to exit the app or tap 'Enter' button to start");
                fileName = input.nextLine();
            } else {
                System.out.println("Enter 'stop' to exit the app or tap 'Enter' button to start again");
                fileName = input.nextLine();
            }
            System.out.println("Please enter the file name");
            userInputProcessor.startConverting();

            running = true;
        }

    }


}
