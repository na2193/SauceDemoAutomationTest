package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    private Map<String, String> dataMap = new HashMap<>();

    public CSVReader(InputStreamReader isr) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader(isr));
    	BufferedReader reader = new BufferedReader(isr);
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts;
            if (line.contains(",")) {
                parts = line.split(",", 2);
            } else if (line.contains(":")) {
                parts = line.split(":", 2);
            } else {
                continue; // skip malformed lines
            }

            String key = parts[0].trim();
            String value = parts[1].trim();
            dataMap.put(key, value);
        }

        reader.close();
    }

    public String get(String key) {
        return dataMap.get(key);
    }
}
