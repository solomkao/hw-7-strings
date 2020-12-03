package com.solomka;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //First task
        String str = "A group of 76 nuns.j tested positive for COVID-19 in an outbreak at " +
                "a Franciscan convent in Germany, church officials announced on Tuesday.";
        Map<Character, Integer> chars = StringUtils.getLetters(str);
        System.out.println("Letters = " + chars);
        int size = StringUtils.getNumberOfLetters(str);
        System.out.println("Number of letters = " + size);
        size = StringUtils.getNumberOfSpaces(str);
        System.out.println("Number of spaces = " + size);
        size = StringUtils.getNumberOfDigit(str);
        System.out.println("Number of figures = " + size);
        size = StringUtils.getNumberOfPunctuationMarks("!The string is full,. /,${} []? :;");
        System.out.println("Number of punctuation marks = " + size);

        //Second Task
        String filePath = "WarAndPeace.txt";
        String shortestWord = TextUtils.findShortestWord(filePath);
        System.out.println("The shortest word " + shortestWord);
        String longestWord = TextUtils.findLongestWord(filePath);
        System.out.println("The longest word " + longestWord);
    }
}
