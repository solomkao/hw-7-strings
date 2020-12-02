package com.solomka;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String str = "A group of 76 nuns tested positive for COVID-19 in an outbreak at " +
                "a Franciscan convent in Germany, church officials announced on Tuesday.";
        Map<Character, Integer> chars = StringUtils.getLetters(str);
        System.out.println("Letters = " + chars);
        int size = StringUtils.getNumberOfLetters("Sim ple str ing 2 , Lisa");
        System.out.println("Number of letters = " + size);
        size = StringUtils.getNumberOfSpaces(" 1 2 3 4 5 6 7 8 9 10");
        System.out.println("Number of spaces = " + size);
        size = StringUtils.getNumberOfDigit(str);
        System.out.println("Number of figures = " + size);
        size = StringUtils.getNumberOfPunctuationMarks("!The string is full,. /,${} []? :;");
        System.out.println("Number of punctuation marks = " + size);

    }
}
