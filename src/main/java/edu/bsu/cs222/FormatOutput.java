package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import java.io.IOException;
import java.util.*;

public class FormatOutput {
    static ArrayList<String> formatOutput (String userInput) throws IOException {
        JSONArray usernames = WikipediaReader.getUsernames(userInput);
        JSONArray timestamps = WikipediaReader.getTimestamps(userInput);
        ArrayList<String> revisions = new ArrayList<>();
        for (int j = 0; j < usernames.size(); j++) {
            revisions.add("Timestamp: " + timestamps.get(j) + "  " + "Username: " + usernames.get(j) + "\n");
        }
        return revisions;
    }
}
