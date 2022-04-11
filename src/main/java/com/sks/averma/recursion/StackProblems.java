package com.sks.averma.recursion;

import java.util.Stack;

public class StackProblems {
    static class SortStack {
        public void sort_stack(Stack<Integer> stack) {
            if (stack == null) return;
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) temp.push(stack.pop());
            stack.push(temp.pop());
            while (!temp.isEmpty()) {
                if (temp.peek() >= stack.peek()) stack.push(temp.pop());
                else {
                    int t = temp.pop();
                    while (!stack.isEmpty() && t < stack.peek()) temp.push(stack.pop());
                    stack.push(t);
                }
            }
        }

        public void sort_stack_recursive(Stack<Integer> stack) {
            if (stack.isEmpty()) return;
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) temp.push(stack.pop());
            sort_stack_recursive(stack, temp);
        }

        private void sort_stack_recursive(Stack<Integer> stack, Stack<Integer> temp) {
            if (temp.isEmpty()) return;
            if (stack.isEmpty() || temp.peek() >= stack.peek()) stack.push(temp.pop());
            else {
                int t = temp.pop();
                while (!stack.isEmpty() && t < stack.peek()) temp.push(stack.pop());
                stack.push(t);
            }
            sort_stack_recursive(stack, temp);
        }
    }

    static class StackMiddleDeletion {
        public void deleteMiddle(Stack<Integer> stack) {
            if (stack == null || stack.isEmpty()) return;
            Stack<Integer> temp = new Stack<>();
            int size = 0;
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
                size++;
            }
            int middle = size / 2 + size % 2;
            while (middle > 1) {
                stack.push(temp.pop());
                middle--;
            }
            temp.pop();
            while (!temp.isEmpty()) stack.push(temp.pop());

        }
    }

    static class StackReverse {
        /**
         * Time Complexity: O(n^2)
         * Space Complexity: O(n) - for method/recursion stack
         * Hypothesis: function reverses a stack
         */
        public static void reverseStack_recursion(Stack<Integer> stack) {
            // Base Condition
            if (stack.isEmpty())
                return;

            // Induction
            int e1 = stack.pop();
            reverseStack_recursion(stack);
            insert(stack, e1);
        }

        private static void insert(Stack<Integer> s, int e) {
            if (s.isEmpty()) {
                s.push(e);
                return;
            }
            Stack<Integer> s1 = new Stack<>();
            while (!s.isEmpty()) s1.push(s.pop());
            s.push(e);
            while (!s1.isEmpty()) s.push(s1.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(4);
        stack.push(0);
        stack.push(9);
        stack.push(2);
        System.out.println("Stack = " + stack);
        new SortStack().sort_stack(stack);
        System.out.println("Sorted = " + stack);

        stack = new Stack<>();
        stack.push(8);
        stack.push(10);
        stack.push(0);
        stack.push(10);
        stack.push(2);
        stack.push(-1);
        System.out.println("Stack = " + stack);
        new SortStack().sort_stack_recursive(stack);
        System.out.println("[Recursive] Sorted = " + stack);

        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack = " + stack);
        new StackMiddleDeletion().deleteMiddle(stack);
        System.out.println("Delete Middle = " + stack);
        new StackMiddleDeletion().deleteMiddle(stack);
        System.out.println("Delete Middle = " + stack);
        new StackReverse().reverseStack_recursion(stack);
        System.out.println("Reversed Stack = " + stack);
    }
}
