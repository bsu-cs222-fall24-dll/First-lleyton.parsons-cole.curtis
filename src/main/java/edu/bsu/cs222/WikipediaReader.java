package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WikipediaReader {
    static JSONArray getTimestamps(String userInput) throws IOException {
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
    static JSONArray getUsernames(String userInput) throws IOException {
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
    static JSONArray getRedirect(String userInput) throws IOException {
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
    static JSONArray getTitle(String userInput) throws IOException {
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
}