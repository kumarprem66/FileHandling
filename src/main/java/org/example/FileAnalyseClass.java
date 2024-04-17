package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileAnalyseClass {

    public Map<String, Integer> analyzeContent(String filePath) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words using whitespace as delimiter
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Remove non-alphabetic characters and convert to lowercase
                    if (!word.isEmpty()) {
                        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1); // Update word frequency
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error analyzing file content: " + e.getMessage());
        }
        return wordFrequencyMap;
    }
}
