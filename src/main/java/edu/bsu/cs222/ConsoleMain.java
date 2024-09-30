package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class ConsoleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the wikipedia article you wish to access: ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            System.err.println(ErrorChecking.noInputError());
        }
        try {
            System.err.println(ErrorChecking.noArticleExists(userInput));
            System.out.println(ErrorChecking.redirectPrintOut(userInput));
            ArrayList<String> revisions = new ArrayList<>(FormatOutput.formatOutput(userInput));
            for (String revision : revisions) {
                System.out.println(revision);
            }
        } catch (IOException ioException) {
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }
}
