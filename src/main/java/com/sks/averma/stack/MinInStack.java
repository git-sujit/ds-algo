package com.sks.averma.stack;

import javafx.util.Pair;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class MinInStack {
    public static void main(String[] args) {
        //testStack_extraSpace();
        //testStack_efficient();
        testStack_superEfficient();
    }

    private static void testStack_superEfficient() {
        System.out.println("\nMyStack_SuperEfficient");
        MyStack_SuperEfficient mStackEff = new MyStack_SuperEfficient();
        demo_push(mStackEff, 10);
        demo_push(mStackEff, 20);
        demo_push(mStackEff, 5);
        demo_push(mStackEff, 50);
        demo_push(mStackEff, 43);
        demo_push(mStackEff, 75);
        demo_push(mStackEff, 1);

        demo_pop(mStackEff);
        demo_pop(mStackEff);
        demo_pop(mStackEff);
        demo_pop(mStackEff);
        demo_pop(mStackEff);
    }

    private static void demo_pop(MyStack_SuperEfficient mStackEff) {
        mStackEff.pop();
        System.out.println("Pop:\tstack = " + mStackEff.stack + ", min = " + mStackEff.min());
    }

    private static void demo_push(MyStack_SuperEfficient mStackEff, int ele) {
        mStackEff.push(ele);
        System.out.println("Push(" + ele + "):\tstack = " + mStackEff.stack + ", min = " + mStackEff.min());
    }

    private static void testStack_efficient() {
        System.out.println("\ntestStack_efficient");
        MyStack_Efficient mStackEff = new MyStack_Efficient();
        mStackEff.push(10);
        mStackEff.push(20);
        System.out.println("stack = " + mStackEff.stack);
        System.out.println("min = " + mStackEff.min());
        mStackEff.push(5);
        mStackEff.push(50);
        mStackEff.push(43);
        System.out.println("stack = " + mStackEff.stack);
        System.out.println("min = " + mStackEff.min());
        mStackEff.push(75);
        mStackEff.push(1);
        System.out.println("stack = " + mStackEff.stack);
        System.out.println("min = " + mStackEff.min());
        mStackEff.pop();
        System.out.println("stack = " + mStackEff.stack);
        System.out.println("min = " + mStackEff.min());
        mStackEff.pop();
        System.out.println("stack = " + mStackEff.stack);
        System.out.println("min = " + mStackEff.min());
        mStackEff.pop();
        mStackEff.pop();
        mStackEff.pop();
        System.out.println("stack = " + mStackEff.stack);
        System.out.println("min = " + mStackEff.min());
    }

    private static void testStack_extraSpace() {
        System.out.println("\ntestStack_extraSpace");
        MyStack_ExtraSpace mStack = new MyStack_ExtraSpace();
        mStack.push(10);
        mStack.push(20);
        System.out.println("stack = " + mStack.stack);
        System.out.println("minStack = " + mStack.minStack);
        System.out.println("min = " + mStack.min());
        mStack.push(5);
        mStack.push(50);
        mStack.push(43);
        System.out.println("stack = " + mStack.stack);
        System.out.println("minStack = " + mStack.minStack);
        System.out.println("min = " + mStack.min());
        mStack.push(75);
        mStack.push(1);
        System.out.println("stack = " + mStack.stack);
        System.out.println("minStack = " + mStack.minStack);
        System.out.println("min = " + mStack.min());
        mStack.pop();
        System.out.println("stack = " + mStack.stack);
        System.out.println("minStack = " + mStack.minStack);
        System.out.println("min = " + mStack.min());
        mStack.pop();
        System.out.println("stack = " + mStack.stack);
        System.out.println("minStack = " + mStack.minStack);
        System.out.println("min = " + mStack.min());
        mStack.pop();
        mStack.pop();
        mStack.pop();
        System.out.println("stack = " + mStack.stack);
        System.out.println("minStack = " + mStack.minStack);
        System.out.println("min = " + mStack.min());
    }

    /**
     * Uses Extra Space
     * Time Complexity: O(1) to get the min, minStack.peek()
     * Space Complexity: O(N), extra stack to maintain min
     */
    static class MyStack_ExtraSpace {
        public Stack<Integer> stack;
        public Stack<Integer> minStack;

        public MyStack_ExtraSpace() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(Integer ele) {
            if (stack.isEmpty() || ele < minStack.peek()) minStack.push(ele);
            stack.push(ele);
        }

        public Integer pop() {
            if (stack.isEmpty()) return -1;
            if (stack.peek() == minStack.peek()) minStack.pop();
            return stack.pop();
        }

        public Integer min() {
            if (minStack.isEmpty()) return -1;
            return minStack.peek();
        }
    }

    static class MyStack_Efficient {
        public Stack<Pair<Integer, Integer>> stack;

        public MyStack_Efficient() {
            this.stack = new Stack<Pair<Integer, Integer>>();
        }

        public void push(Integer ele) {
            if (stack.isEmpty() || ele < stack.peek().getValue()) stack.push(new Pair(ele, ele));
            else stack.push(new Pair<>(ele, stack.peek().getValue()));
        }

        public Integer pop() {
            if (stack.isEmpty()) return null;
            return stack.pop().getKey();
        }

        public Integer min() {
            if (stack.isEmpty()) return null;
            return stack.peek().getValue();
        }
    }

    static class MyStack_SuperEfficient {
        public Stack<Integer> stack;
        public Integer min;

        public MyStack_SuperEfficient() {
            this.stack = new Stack<>();
        }

        public void push(Integer ele) {
            if (stack.isEmpty()) {
                stack.push(ele);
                min = ele;
            } else {
                if (ele < min) {
                    Integer dEle = 2 * ele - min;
                    stack.push(dEle);
                    min = ele;
                } else stack.push(ele);
            }
        }

        public Integer pop() {
            int oldMin = min;
            if (stack.isEmpty()) return -1;
            if (stack.peek() < min) min = 2 * min - stack.peek();
            stack.pop();
            return oldMin;
        }

        public Integer min() {
            if (stack.isEmpty()) return -1;
            else return min;
        }
    }
}
