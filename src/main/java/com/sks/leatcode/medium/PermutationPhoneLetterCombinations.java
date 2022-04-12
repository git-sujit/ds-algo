package com.sks.leatcode.medium;

import java.util.*;

public class PermutationPhoneLetterCombinations {
    /**
     * Time complexity : O(N*4^N)
     * Space complexity: O(N)
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        Map<Character, String> numCharsMap = prepareNumCharsMap_better();
        char first = digits.charAt(0);
        for (char c : numCharsMap.get(first).toCharArray())
            result.add(c + "");
        for (int i = 1; i < digits.length(); i++) {
            List<String> sub = new ArrayList<>();
            for (char c : numCharsMap.get(digits.charAt(i)).toCharArray()) {
                for (String s : result) {
                    sub.add(s + c);
                }
            }
            result = sub;
        }
        return result;
    }

    private static Map<Character, String> prepareNumCharsMap_better() {
        Map<Character, String> numCharsMap = new HashMap<>();
        numCharsMap.put('2', "abc");
        numCharsMap.put('3', "def");
        numCharsMap.put('4', "ghi");
        numCharsMap.put('5', "jkl");
        numCharsMap.put('6', "mno");
        numCharsMap.put('7', "pqrs");
        numCharsMap.put('8', "tuv");
        numCharsMap.put('9', "wxyz");
        return numCharsMap;
    }

    public static void main(String[] args) {
        String digits = "23";
        demo(digits);
    }

    private static void demo(String digits) {
        System.out.println("\nDigits = " + digits);
        System.out.println("Letter Combinations = " + new PermutationPhoneLetterCombinations().letterCombinations(digits));
    }

    private Map<Character, List<Character>> prepareNumCharsMap() {
        Map<Character, List<Character>> numCharsMap = new HashMap<>();
        int start = 'a';
        for (int num = '2'; num <= '9'; num++) {
            if (num == '7' || num == '9') {
                numCharsMap.put((char) num, charsForNum(start, 4));
                start += 4;
            } else {
                numCharsMap.put((char) num, charsForNum(start, 3));
                start += 3;
            }
        }
        return numCharsMap;
    }

    private List<Character> charsForNum(int start, int count) {
        List<Character> numChars = new ArrayList<>();
        for (int i = 0; i < count; i++)
            numChars.add((char) (start + i));
        return numChars;
    }
}
