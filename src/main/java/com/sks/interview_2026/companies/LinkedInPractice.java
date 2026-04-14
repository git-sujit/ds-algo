package com.sks.interview_2026.companies;

import java.util.*;

public class LinkedInPractice {

    public static void main(String[] args) {
        System.out.println("----- LeetCode-17: Phone Letter Combination -----");
        test_phoneLetterCombination();
        System.out.println("----- LeetCode-339: Nested List Depth-Sum -----");
        test_nestedListDepthSum();
        System.out.println("----- LeetCode-528: Random Pick with Weight(SAMPLING) -----");
        test_randomPickWithWeight();
        System.out.println("----- LeetCode-1004: Max Consecutive Ones(with max k flips) -----");
        test_maxConsecutiveOnes_3();
    }


    /**
     * PHONE NUMBER COMBINATION
     * Time complexity : O(N*4^N)
     * Space complexity: O(N)
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations(any order) that the number could represent.
     */
    public static List<String> phoneLetterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
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

    /**
     * DEPTH SUM
     * You are given a nested list of integers nestedList.
     * Each element is either an integer or a list whose elements may also be integers or other lists.
     */
    private int currDepth = 1;

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        List<int[]> eleDepth = new ArrayList<>();
        calculateDepth(nestedList, eleDepth);
        int sum = 0;
        for (int[] ed : eleDepth) {
            sum += (ed[0] * ed[1]);
        }
        return sum;
    }

    public void calculateDepth(List<NestedInteger> nestedList, List<int[]> eleDepth) {
        if (nestedList == null || nestedList.isEmpty()) {
            currDepth--;
            return;
        }
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger ele = nestedList.get(i);
            if (ele.isInteger()) {
                eleDepth.add(new int[]{ele.getInteger(), currDepth});
            } else {
                currDepth++;
                calculateDepth(ele.getList(), eleDepth);
            }
            if (i == nestedList.size() - 1) currDepth--;
        }
    }

    /**
     * RANDOM PICK INDEX
     * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
     * You need to implement the function pickIndex(), which randomly picks an index in the
     * range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
     */
    public static void randomPickWithWeight(int[] w, int pickTimes) {
        int[] prefixSum = new int[w.length];
        Random random = new Random();
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        for (int i = 0; i < pickTimes; i++)
            System.out.println("Pick-" + 1 + " => " + pickIndex(w, prefixSum));
    }

    private static int pickIndex(int[] w, int[] prefixSum) {
        if (w == null || w.length == 0) return -1;
        Random random = new Random();
        int randSum = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        return binarySearch(prefixSum, randSum);
    }

    private static int binarySearch(int[] prefixSum, int randSum) {
        if (prefixSum == null || prefixSum.length == 0) return -1;
        int s = 0, e = prefixSum.length - 1, ceil = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (randSum <= prefixSum[m]) {
                ceil = m;
                e = m - 1;
            } else s = m + 1;
        }
        return ceil;
    }

    /**
     * MAX CONSECUTIVE ONEs : Sliding Window
     * => This problem is equivalent to finding the longest subarray with at most k zeroes.
     * Given a binary array nums and an integer k, return the maximum number of
     * consecutive 1's in the array if you can flip at most k 0's.
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static int maxConsecutiveOnes_3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return -1;
        int ws = 0, we = 0, maxOnes = 0, zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[ws] == 0) zeros--;
                ws++;
            }
            maxOnes = Math.max(maxOnes, we - ws + 1);
            we++;
        }
        return maxOnes;
    }

    /**
     * TEST
     */
    private static void test_phoneLetterCombination() {
        String digits = "23";
        System.out.println("Digits = " + digits);
        System.out.println("Letter Combinations = " + phoneLetterCombinations(digits));
        digits = "956";
        System.out.println("Digits = " + digits);
        System.out.println("Letter Combinations = " + phoneLetterCombinations(digits));
    }

    private static void test_nestedListDepthSum() {
    }

    private static void test_randomPickWithWeight() {
        int[] w = new int[]{1, 2, 3};
        int pickTimes = 6;
        System.out.println("w = " + Arrays.toString(w) + ", pickTimes = " + pickTimes);
        randomPickWithWeight(w, pickTimes);
    }

    private static void test_maxConsecutiveOnes_3() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Nums = " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("Max consecutive 1s with most " + k + " flips = " + maxConsecutiveOnes_3(nums, k));
    }
}

class NestedInteger {
    int value;
    List<NestedInteger> nestedList;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return nestedList == null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        nestedList.add(ni);
    }


    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return this.nestedList;
    }
}
