package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class RevisionParserTest {
    @Test
    public void testParseTimestamp() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray timestamp = parser.parseTimestamp(testDataStream);
        assertEquals(timestamp, timestamp);
    }
    @Test
    public void testParseUsername() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray username = parser.parseUsername(testDataStream);
        assertEquals(username, username);

    }
    @Test
    public void testParseRedirect() throws IOException{
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray redirect = parser.parseRedirect(testDataStream);
        assertEquals(redirect, redirect);
    }
    @Test
    public void testParseTitle() throws IOException{
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray title = parser.parseTitle(testDataStream);
        assertEquals(title, title);
    }
    @Test
    public void testParseMissing() throws IOException{
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray missing = parser.parseMissing(testDataStream);
        assertEquals(missing, missing);
    }
}