/*
package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserTest {
    @Test
    public void testParseTimestamp() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.parseTimestamp(testDataStream);
        Assertions.assertEquals("2024-09-11T20:15:43Z", timestamp);
    }
    @Test
    public void testParseUsername() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String username = parser.parseUsername(testDataStream);
        Assertions.assertEquals("CurryTime7-24", username);

    }
}
*/