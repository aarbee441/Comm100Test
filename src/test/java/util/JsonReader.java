package util;

import io.restassured.path.json.JsonPath;

import java.io.File;

public class JsonReader {

    static JsonPath jsonPath = new JsonPath(new File("src/test/resources/testData/staticContent.json"));

    public static String getValue(String key){
       return jsonPath.get(key);
    }

}
