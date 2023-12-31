package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class JSONDiff {

    public static List<String> getJSONDiff(String json1, String json2) {
        // Parse JSON strings into maps
        Map<String, String> obj1 = parseJSON(json1);
        Map<String, String> obj2 = parseJSON(json2);

        // Initialize a list to store different keys
        List<String> differentKeys = new ArrayList<>();

        // Compare keys and values
        for (String key : obj1.keySet()) {
            if (obj2.containsKey(key)) {
                // Check if values are different
                if (!obj1.get(key).equals(obj2.get(key))) {
                    differentKeys.add(key);
                }
            }
        }

        // Sort the list in lexicographically ascending order
        Collections.sort(differentKeys);

        return differentKeys;
    }

    private static Map<String, String> parseJSON(String json) {
        // Simple JSON parser for key-value pairs
        Map<String, String> map = new HashMap<>();
        String[] pairs = json.substring(1, json.length() - 1).split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim().replaceAll("\"", "");
            String value = keyValue[1].trim().replaceAll("\"", "");
            map.put(key, value);
        }
        return map;
    }

    public static void main(String[] args) {
        // Example usage
        String json1 = "{\"hello\":\"world\",\"hi\":\"hello\",\"you\":\"me\"}";
        String json2 = "{\"hello\":\"world\",\"hi\":\"helloo\",\"you\":\"me\"}";

        List<String> result = getJSONDiff(json1, json2);

        System.out.println(result);  // Output: [hi]
    }
}