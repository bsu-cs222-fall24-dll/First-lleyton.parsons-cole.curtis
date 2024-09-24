package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WikipediaReaderTest {
    @Test
    public void getTimestampsTest() throws IOException {
        JSONArray timestamps = WikipediaReader.getTimestamps("Lamp");
        JSONArray testTimestamps = new JSONArray();
        testTimestamps.add("2024-09-11T20:15:43Z");
        assertEquals(timestamps.getFirst(), testTimestamps.getFirst());
    }

    @Test
    public void getUsernamesTest() throws IOException {
        JSONArray usernames = WikipediaReader.getUsernames("Lamp");
        JSONArray testUsernames = new JSONArray();
        testUsernames.add("CurryTime7-24");
        assertEquals(usernames.getFirst(), testUsernames.getFirst());
    }

    @Test
    public void getRedirectTest() throws IOException {
        JSONArray redirect = WikipediaReader.getRedirect("Zappa");
        JSONArray testRedirect = new JSONArray();
        testRedirect.add("");
        assertNotEquals(redirect.getFirst(), testRedirect.getFirst());
    }

    @Test
    public void getTitleTest() throws IOException {
        JSONArray title = WikipediaReader.getTitle("Lamp");
        JSONArray testTitle = new JSONArray();
        testTitle.add("Lamp");
        assertEquals(title.getFirst(), testTitle.getFirst());
    }
    @Test
    public void getMissingTest() throws IOException {
        JSONArray missing = WikipediaReader.getMissing("dsxhfisdfdhsfwfhdshfdkjsb");
        JSONArray testMissing = new JSONArray();
        testMissing.add("");
        assertEquals(missing.getFirst(), testMissing.getFirst());
    }
}
