package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class RevisionParser {
    public JSONArray parseTimestamp(InputStream testDataStream) throws IOException {
        return JsonPath.read(testDataStream, "$..timestamp");
    }
    public JSONArray parseUsername(InputStream testDataStream) throws IOException {
        return JsonPath.read(testDataStream, "$..user");
    }
    public JSONArray parseRedirect(InputStream testDataStream) throws IOException{
        return JsonPath.read(testDataStream, "$..redirects");
    }
    public JSONArray parseTitle(InputStream testDataStream) throws IOException{
        return JsonPath.read(testDataStream, "$..title");
    }
    public JSONArray parseMissing(InputStream testDataStream) throws IOException{
        return JsonPath.read(testDataStream, "$..missing");
    }
}
