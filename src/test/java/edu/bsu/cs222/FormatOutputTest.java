package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FormatOutputTest{
    @Test
    public void testFormatOutput() throws IOException {
    String testInput = "Lamp";
    System.out.println("Test 1:");
    FormatOutput.formatOutput(testInput);
    }
    @Test
    public void testFormatOutputRedirect() throws IOException {
        String testInput = "Zappa";
        System.out.println("Test 2:");
        FormatOutput.formatOutput(testInput);
    }
}
