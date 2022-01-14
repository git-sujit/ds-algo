package com.sks.leatcode.easy;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else {
            if (val < min) {
                int derived = 2 * val - min;
                stack.push(derived);
                min = val;
            } else stack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek() < min) min = 2 * min - stack.peek();
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        if (stack.peek() < min) return 2 * min - stack.peek();
        else return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        int val = 10;
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
