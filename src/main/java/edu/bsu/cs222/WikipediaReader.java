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
        String line = scanner.nextLine();
        try {
            String timestamp = wikipediaReader.getLatestRevisionOf(line);
            System.out.println(timestamp);
        } catch (IOException ioException){
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }

    private String getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&ryprop=timestamp&rylimit=1", articleTitle);
        String encodedUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaReader/0.1 (cole.curtis@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            RevisionParser revisionParser = new RevisionParser();
            String timestamp = revisionParser.parse(inputStream);
            return timestamp;
        } catch (MalformedURLException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
    }
}

