package com.sks.FBprep;

import java.util.*;

import javafx.util.*;

public class MatchingPairs {
    int matchingPairs(String s, String t) {
        System.out.println("\ns = " + s + ", t = " + t);
        int n = s.length();
        List<Integer> unMatchedIdx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                unMatchedIdx.add(i);
        }
        System.out.println("unMatchedIdx = " + unMatchedIdx);
        if (unMatchedIdx.size() == 0)
            return matchCount(swap(s, 0, n - 1), t, n);
        else
            return matchCount(s, t, n) + swapGain(s, t, unMatchedIdx);
    }

    int swapGain(String s, String t, List<Integer> unMatchedIdx) {
        Set<Pair<Character, Character>> st = new HashSet<>();
        Set<Pair<Character, Character>> ts = new HashSet<>();
        for (int i : unMatchedIdx) {
            st.add(new Pair(s.charAt(i), t.charAt(i)));
            ts.add(new Pair(t.charAt(i), s.charAt(i)));
        }
        System.out.println("st = " + st);
        System.out.println("ts = " + ts);
        for (Pair e : st) {
            if (ts.contains(e))
                return 2;
        }
        for (Pair e : st) {
            for (Pair e1 : ts)
                if (e.getKey() == e1.getKey() || e.getValue() == e1.getValue())
                    return 1;
        }
        return 0;
    }

    String swap(String str, int i, int j) {
        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1, str.length());
    }

    int matchCount(String s, String t, int n) {
        int matchCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i))
                matchCount++;
        }
        return matchCount;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }

    class CustomPair{
        public char key;
        public char value;
        public CustomPair(char key, char value){
            this.key =key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return Character.valueOf(key).hashCode() + Character.valueOf(value).hashCode();
        }

        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            CustomPair that = (CustomPair) obj;
            return this.key == that.key && this.value == that.value;
        }
    }
}
