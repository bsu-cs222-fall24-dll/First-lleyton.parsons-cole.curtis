package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ErrorCheckingTest {
    @Test
    public void testNoArticleExists() throws IOException {
        System.out.println("Test 1:");
        String userInput = "dfasfblaknflkasnklfnasklfndfnlkdsnflkdsnfl";
        String errorResult = ErrorChecking.noArticleExists(userInput);
        assertEquals("No article exists for that input.",errorResult);
    }
    @Test
    public void testNoArticleExistsLamp() throws IOException {
        String userInput = "Lamp";
        System.out.println("Test 2:");
        ErrorChecking.noArticleExists(userInput);
    }
}
