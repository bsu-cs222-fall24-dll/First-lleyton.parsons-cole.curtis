package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParser {
    public String parseTimestamp(InputStream testDataStream) throws IOException {
        JSONArray revisionTimestamps  = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        return revisionTimestamps.toString();
    }
    public String parseUsername(InputStream testDataStream) throws IOException {
        JSONArray revisionUsernames  = (JSONArray) JsonPath.read(testDataStream, "$..user");
        return revisionUsernames.toString();
    }
}
