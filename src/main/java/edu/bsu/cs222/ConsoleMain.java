package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the wikipedia article you wish to access: ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            ErrorChecking.noInputError();
        }
        try {
            FormatOutput.formatOutput(userInput);
        } catch (IOException ioException) {
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }
}
