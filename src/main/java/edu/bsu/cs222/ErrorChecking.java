package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;

public class ErrorChecking {
    static void noInputError(){
        System.err.println("Expecting Wikipedia article name: No article name provided.");
    }
    static void noArticleExists(String userInput) throws IOException {
        JSONArray missing = WikipediaReader.getMissing(userInput);
        if (!missing.isEmpty()){
            System.err.println("No article exists for that input.");
        }
    }
}
