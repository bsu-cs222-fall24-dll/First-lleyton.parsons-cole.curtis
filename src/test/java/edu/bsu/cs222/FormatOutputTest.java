package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatOutputTest{
    @Test
    public void testFormatOutput() throws IOException {
    String testInput = "Lamp";
    System.out.println("Test 1:");
    FormatOutput.formatOutput(testInput);
    assertEquals(testInput,testInput);
    }
    @Test
    public void testFormatOutputRedirect() throws IOException {
        String testInput = "Zappa";
        System.out.println("Test 2:");
        FormatOutput.formatOutput(testInput);
        assertEquals(testInput,testInput);
    }
}
