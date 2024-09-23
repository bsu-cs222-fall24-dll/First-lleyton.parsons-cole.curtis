package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParserTest {
    @Test
    public void testParseTimestamp() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray timestamp = parser.parseTimestamp(testDataStream);
        Assertions.assertEquals(timestamp, timestamp);
    }
    @Test
    public void testParseUsername() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray username = parser.parseUsername(testDataStream);
        Assertions.assertEquals(username, username);

    }
    @Test
    public void testParseRedirect() throws IOException{
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray redirect = parser.parseRedirect(testDataStream);
        Assertions.assertEquals(redirect, redirect);
    }
}