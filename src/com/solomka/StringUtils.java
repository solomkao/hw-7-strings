package com.solomka;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static Map<Character, Integer> getLetters(String str) {
        if (str == null || str.isBlank()) {
            return null;
        }
        str = str.toLowerCase().trim();
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);
            if (key >= 97 && key <= 122) {
                if (!chars.containsKey(key)) {
                    chars.put(key, 1);
                } else {
                    chars.replace(key, (chars.get(key) + 1));
                }
            }
        }
        return chars;
    }

    public static int getNumberOfLetters(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }
        int size = 0;
        str = str.toLowerCase().trim();
        for (Character c : str.toCharArray()) {
            if (c >= 97 && c <= 122) {
                size++;
            }
        }
        return size;
    }

    public static int getNumberOfSpaces(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int size = 0;
        for (Character c : str.toCharArray()) {
            if (c == 32) {
                size++;
            }
        }
        return size;
    }

    public static int getNumberOfDigit(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }
        int size = 0;
        for (Character c : str.toCharArray()) {
            if (c >= 48 && c <= 57) {
                size++;
            }
        }
        return size;
    }

    public static int getNumberOfPunctuationMarks(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }
        Pattern punctuationPattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = punctuationPattern.matcher(str);
        int size = 0;
        while (matcher.find()) {
            size++;
        }
        return size;
    }
}
