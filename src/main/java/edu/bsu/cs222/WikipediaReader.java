package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;

public class WikipediaReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the wikipedia article you wish to access: ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            noInputError();
        }
        try {
            formatOutput(userInput);
        } catch (IOException ioException) {
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }

    private static JSONArray getTimestamps(String userInput) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(userInput, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            return revisionParser.parseTimestamp(inputStream);
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

    private static JSONArray getUsernames(String userInput) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(userInput, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            return revisionParser.parseUsername(inputStream);
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
    private static JSONArray getRedirect (String userInput) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(userInput, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            return revisionParser.parseRedirect(inputStream);
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
    private static JSONArray getTitle (String userInput) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(userInput, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            return revisionParser.parseTitle(inputStream);
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
    public static void formatOutput (String userInput) throws IOException {
        JSONArray usernames = getUsernames(userInput);
        JSONArray timestamps = getTimestamps(userInput);
        JSONArray redirect = getRedirect(userInput);
        JSONArray title = getTitle(userInput);
        if (redirect.isEmpty()) {
            System.out.println();
        }
        else{
            System.out.println("Redirected to " + title.getFirst());
        }
        for (int j = 0; j < usernames.size(); j++) {
            System.out.println("\nUsername: " + usernames.get(j) + "\n" + "Timestamp: " + timestamps.get(j));
        }
    }
    public static void noInputError(){
        System.err.println("Expecting Wikipedia article name: No article name provided.");
    }
}