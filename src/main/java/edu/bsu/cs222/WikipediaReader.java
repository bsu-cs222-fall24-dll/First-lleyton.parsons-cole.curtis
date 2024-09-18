package edu.bsu.cs222;

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
        WikipediaReader wikipediaReader = new WikipediaReader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the wikipedia article you wish to access: ");
        String line = scanner.nextLine();
        try {
            String timestamps = wikipediaReader.getTimestamps(line);
            System.out.println(timestamps);
            String usernames = wikipediaReader.getUsernames(line);
            System.out.println(usernames);
        } catch (IOException ioException){
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }

    private String getTimestamps(String articleTitle) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(articleTitle, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=4&redirects";
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            return revisionParser.parseTimestamp(inputStream);
        } catch (MalformedURLException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
    }
    private String getUsernames(String articleTitle) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(articleTitle, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=4&redirects";
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            return revisionParser.parseUsername(inputStream);
        } catch (MalformedURLException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
    }
}

