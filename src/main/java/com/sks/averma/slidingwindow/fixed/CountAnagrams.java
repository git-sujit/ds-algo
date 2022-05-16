package com.sks.averma.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
 */
public class CountAnagrams {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int count_slidingWindow_better(String txt, String pat) {
        if (txt == null | txt.length() == 0 || pat == null || pat.length() == 0 || pat.length() > txt.length())
            return -1;
        int[] masterCharCount = new int[26];
        for (char c : pat.toCharArray())
            masterCharCount[c - 'a']++;
        int anagramCount = 0;
        int ws = 0;
        int we = 0;
        int[] tempCharCount = new int[26];
        while (we < txt.length()) {
            tempCharCount[txt.charAt(we) - 'a']++;
            if (we - ws + 1 == pat.length()) {
                if (isAnagram(tempCharCount, masterCharCount))
                    anagramCount++;
                tempCharCount[txt.charAt(ws++) - 'a']--;
            }
            we++;
        }
        return anagramCount;
    }

    private static boolean isAnagram(int[] tempCharCount, int[] masterCharCount) {
        for (int i = 0; i < 26; i++)
            if (tempCharCount[i] != masterCharCount[i]) return false;
        return true;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int count_slidingWindow(String txt, String pat) {
        if (txt == null | txt.length() == 0 || pat == null || pat.length() == 0 || pat.length() > txt.length())
            return -1;
        int anagramCount = 0;
        Map<Character, Integer> masterCharCountMap = new HashMap<>();
        for (Character c : pat.toCharArray())
            masterCharCountMap.put(c, masterCharCountMap.getOrDefault(c, 0) + 1);

        int windowStart = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < txt.length(); windowEnd++) {
            Character c = txt.charAt(windowEnd);
            if (masterCharCountMap.containsKey(c))
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);

            if (windowEnd - windowStart + 1 == pat.length()) {
                if (charCountMap.size() == masterCharCountMap.size() && charCountMap.equals(masterCharCountMap)) {
                    //System.out.println("Anagram found at index-" + windowStart + ", charCountMap = " + charCountMap);
                    anagramCount++;
                }
                if (charCountMap.containsKey(txt.charAt(windowStart))) {
                    char sc = txt.charAt(windowStart);
                    int count = charCountMap.get(sc);
                    if (count == 1) charCountMap.remove(sc);
                    else charCountMap.put(sc, count - 1);
                }
                windowStart++;
            }
        }
        return anagramCount;
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int count_bruteForce(String txt, String pat) {
        if (txt == null | txt.length() == 0 || pat == null || pat.length() == 0 || pat.length() > txt.length())
            return -1;
        int anagramCount = 0;
        Map<Character, Integer> masterCharCountMap = new HashMap<>();
        for (Character c : pat.toCharArray()) {
            if (masterCharCountMap.containsKey(c)) masterCharCountMap.put(c, masterCharCountMap.get(c) + 1);
            else masterCharCountMap.put(c, 1);
        }
        //System.out.println("masterCharCountMap = " + masterCharCountMap);
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (int j = i; j < pat.length() + i; j++) {
                Character ch = txt.charAt(j);
                if (charCountMap.containsKey(ch)) charCountMap.put(ch, charCountMap.get(ch) + 1);
                else charCountMap.put(ch, 1);
            }
            if (charCountMap.equals(masterCharCountMap)) {
                //System.out.println("Anagram found at index-" + i + ", charCountMap = " + charCountMap);
                anagramCount++;
            }
        }
        return anagramCount;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        test(txt, pat);

        txt = "forrxxorfxdorfr";
        pat = "fror";
        test(txt, pat);
    }

    private static void test(String txt, String pat) {
        System.out.println("\nText = " + txt + ", Pattern = " + pat);
        System.out.println("[Sliding Window]Count of Anagrams of pattern = " + count_slidingWindow(txt, pat));
        System.out.println("[Better-Sliding Window]Count of Anagrams of pattern = " + count_slidingWindow_better(txt, pat));
        System.out.println("[Brute Force] Count of Anagrams of pattern = " + count_bruteForce(txt, pat));
    }
}
