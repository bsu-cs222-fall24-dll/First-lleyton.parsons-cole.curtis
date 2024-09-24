package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ErrorCheckingTest {
    @Test
    public void testNoArticleExists() throws IOException {
        System.out.println("Test 1:");
        String userInput = "dfasfblaknflkasnklfnasklfndfnlkdsnflkdsnfl";
        ErrorChecking.noArticleExists(userInput);
    }
    @Test
    public void testNoArticleExistsLamp() throws IOException {
        String userInput = "Lamp";
        System.out.println("Test 2:");
        ErrorChecking.noArticleExists(userInput);
    }
}
