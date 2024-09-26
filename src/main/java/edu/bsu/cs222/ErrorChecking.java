package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;

public class ErrorChecking {
    static String noInputError(){
        return("Expecting Wikipedia article name: No article name provided.");
    }
    static String noArticleExists(String userInput) throws IOException {
        JSONArray missing = WikipediaReader.getMissing(userInput);
        if (!missing.isEmpty()){
            return("No article exists for that input.");
        }
        return("");
    }
    static String redirectPrintOut(String userInput) throws IOException {
        JSONArray redirect = WikipediaReader.getRedirect(userInput);
        JSONArray title = WikipediaReader.getTitle(userInput);
        if (redirect.isEmpty()) {
            return("");
        }
        else{
            return("Redirected to " + title.getFirst());
        }
    }
}
