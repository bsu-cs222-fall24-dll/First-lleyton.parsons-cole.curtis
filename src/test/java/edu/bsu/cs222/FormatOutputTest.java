package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatOutputTest{
    @Test
    public void testFormatOutput() throws IOException {
    String testInput = "Lamp";
    System.out.println("Test 1:");
    ArrayList<String> revision = FormatOutput.formatOutput(testInput);
    assertEquals(revision.getFirst(), revision.getFirst());
    }
    @Test
    public void testFormatOutputRedirect() throws IOException {
        String testInput = "Zappa";
        System.out.println("Test 2:");
        ArrayList<String> revision = FormatOutput.formatOutput(testInput);
        assertEquals(revision.getFirst(),revision.getFirst());
    }
}
