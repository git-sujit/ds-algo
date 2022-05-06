package com.sks.leetcode.medium;

import java.util.*;

public class ShortestUniqueSubstring {
    public static Map<String, String> shortestUniqueSubstr(String[] strArr) {
        Map<String, String> sus = new HashMap<>();
        if (strArr == null || strArr.length == 0) return sus;
        Map<String, Set<String>> strSubMap = prepareSubMap(strArr);
        //System.out.println("strSubMap = " + strSubMap);
        for (String str : strArr) {
            sus.put(str, getUniqueSub(str, strSubMap));
        }
        return sus;
    }

    private static String getUniqueSub(String str, Map<String, Set<String>> strSubMap) {
        String unq = "";
        Set<String> currSet = strSubMap.remove(str);
        Set<String> remSet = new HashSet<>();
        for (String key : strSubMap.keySet()) {
            remSet.addAll(strSubMap.get(key));
        }
        for (String sub : currSet) {
            if (!remSet.contains(sub)) {
                unq = sub;
                break;
            }
        }
        strSubMap.put(str, currSet);
        return unq;
    }

    private static Map<String, Set<String>> prepareSubMap(String[] strArr) {
        Map<String, Set<String>> strSubMap = new HashMap<>();
        for (String str : strArr) {
            strSubMap.put(str, new LinkedHashSet<>());
            for (int l = 1; l <= str.length(); l++) {
                for (int i = 0; i + l <= str.length(); i++) {
                    strSubMap.get(str).add(str.substring(i, i + l));
                }
            }
        }
        return strSubMap;
    }

    public static void main(String[] args) {
        String[] strArr = {"Sujit", "Sumit", "Suprit"};
        demo(strArr);

        strArr = new String[]{"cheapair", "cheapoair", "peloton", "pelican"};
        demo(strArr);
    }

    private static void demo(String[] strArr) {
        System.out.println("strArr = " + strArr);
        System.out.println("Shortest Unique Substring = " + shortestUniqueSubstr(strArr));
    }
}
