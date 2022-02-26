package com.sks.leatcode.hard;

import java.util.*;

/**
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * Implement the FreqStack class:
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 */

/**
 * Time:
 * - Push: O(1)
 * - Pop : O(n^2)
 * Space: O(n)
 */
public class FreqStack {
    private Stack<Integer> stack;
    private Map<Integer, Integer> countMap;

    public FreqStack() {
        stack = new Stack<>();
        countMap = new HashMap<>();
    }

    public void push(int val) {
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        stack.push(val);
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        Set<Integer> maxFreqSet = getMaxFrequencyElements(countMap);
        Stack<Integer> temp = new Stack<>();
        int out = -1;
        while (!stack.isEmpty()) {
            if (maxFreqSet.contains(stack.peek())) {
                out = stack.pop();
                if (countMap.get(out) == 1) countMap.remove(out);
                else countMap.put(out, countMap.get(out) - 1);
                break;
            } else {
                temp.push(stack.pop());
            }
        }
        while (!temp.isEmpty())
            stack.push(temp.pop());
        return out;
    }

    private Set<Integer> getMaxFrequencyElements(Map<Integer, Integer> countMap) {
        Set<Integer> maxFreqSet = new HashSet<>();
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
            maxFreq = Math.max(maxFreq, entry.getValue());
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
            if (entry.getValue() == maxFreq) maxFreqSet.add(entry.getKey());
        return maxFreqSet;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println("Stack = " + freqStack.stack);
        System.out.println("Count Map = " + freqStack.countMap);
        freqStack.pop();
        System.out.println("Stack = " + freqStack.stack);
        System.out.println("Count Map = " + freqStack.countMap);
        //freqStack.pop();
        //freqStack.pop();
        //freqStack.pop();
    }
}
