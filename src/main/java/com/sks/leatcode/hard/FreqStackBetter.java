package com.sks.leatcode.hard;
/**
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * Implement the FreqStack class:
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 */

import java.util.*;

/**
 * Time:
 * - Push: O(1)
 * - Pop : O(1)
 * Space: O(n)
 */
public class FreqStackBetter {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStackBetter() {
        freq = new HashMap();
        group = new HashMap();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        /*-Stack<Integer> s = group.getOrDefault(f, new Stack<>());
        s.push(val);
        group.put(f, s); */
        group.computeIfAbsent(f, z -> new Stack<>()).push(val);
        System.out.println("push(" + val + ") : " + "freq = " + freq + ", group = " + group + ", maxFreq = " + maxFreq);
    }

    public int pop() {
        Stack<Integer> s = group.get(maxFreq);
        int e = s.pop();
        if (s.isEmpty()) {
            group.remove(maxFreq);
            maxFreq--;
        }
        if (freq.get(e) == 1)
            freq.remove(e);
        else
            freq.put(e, freq.get(e) - 1);
        System.out.println("pop()   : " + "freq = " + freq + ", group = " + group + ", maxFreq = " + maxFreq);
        return e;
    }

    public static void main(String[] args) {
        FreqStackBetter freqStack = new FreqStackBetter();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
    }
}
