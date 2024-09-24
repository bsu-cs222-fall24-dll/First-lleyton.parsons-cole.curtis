package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;

public class FormatOutput {
    static void formatOutput (String userInput) throws IOException {
        JSONArray usernames = WikipediaReader.getUsernames(userInput);
        JSONArray timestamps = WikipediaReader.getTimestamps(userInput);
        JSONArray redirect = WikipediaReader.getRedirect(userInput);
        JSONArray title = WikipediaReader.getTitle(userInput);
        if (redirect.isEmpty()) {
            System.out.println();
        }
        else{
            System.out.println("Redirected to " + title.getFirst());
        }
        for (int j = 0; j < usernames.size(); j++) {
            System.out.println("\nTimestamp: " + timestamps.get(j) + "  " + "Username: " + usernames.get(j) + "\n");
        }
    }
}
