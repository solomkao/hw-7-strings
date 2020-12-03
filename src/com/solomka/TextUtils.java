package com.solomka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextUtils {

    private static List<String> getListOfString(String path) {
        List<String> listOfWords = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)))) {
            scanner.useDelimiter("\\p{Space}");
            while (scanner.hasNext()) {
                String value = scanner.next();
                value = value.replaceAll("[,.;:!?\"<>'{}\\[\\]()—*+%$@|\\\\/“”]+", "")
                        .replaceAll("\\p{Digit}", "").trim();
                if (value.contains("-") && value.length() == 1) {
                    continue;
                }
                if (!value.isBlank()) {
                    listOfWords.add(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfWords;
    }

    public static String findShortestWord(String filePath) {
        List<String> words = getListOfString(filePath);
        SortedMap<Integer, String> map = getSortedStrings(words);
        int index = map.firstKey();
        String shortestWord = map.get(index).toLowerCase();
        int count = countOccurrences(words, shortestWord.trim());
        return "[" + shortestWord + "] is repeated " + count + " times";
    }

    public static String findLongestWord(String filePath) {
        List<String> words = getListOfString(filePath);
        SortedMap<Integer, String> map = getSortedStrings(words);
        int index = map.lastKey();
        String longestWord = map.get(index).toLowerCase();
        int count = countOccurrences(words, longestWord.trim());
        return "[" + longestWord + "] is repeated " + count + " times";
    }

    private static SortedMap<Integer, String> getSortedStrings(List<String> words) {
        SortedMap<Integer, String> map = new TreeMap<>();
        for (String word : words) {
            if (!map.containsKey(word.length())) {
                map.put(word.length(), word.trim());
            } else {
                String oldValue = map.get(word.length());
                if (oldValue.compareToIgnoreCase(word) > 0) {
                    map.put(word.length(), word);
                }
            }
        }
        return map;
    }

    private static int countOccurrences(List<String> words, String src) {
        int count = 0;
        for (String word : words) {
            if (word.compareToIgnoreCase(src) == 0) {
                count++;
            }
        }
        return count;
    }
}
