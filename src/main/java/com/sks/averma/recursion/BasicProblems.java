package com.sks.averma.recursion;

import java.util.Arrays;
import java.util.Stack;

/**
 * APPROACHES
 * 1. Hypothesis - Base Condition - Induction
 * 2. Recursion Tree
 * 3. Choice Diagram
 */
public class BasicProblems {
    /**
     * 1. Design Hypothesis: Suppose that print_1_n() function prints numbers 1...n
     */
    public static void print_1_n(int n) {
        // 2. Base Condition
        if (n == 0) return;
        // 3. Induction: Call function with smaller input
        print_1_n(n - 1); // Think: --n/n-- will not work, infinite loop
        System.out.print(n + " ");
    }

    /**
     * Tail recursion: last statement is recursion call
     */
    public static void print_n_1(int n) {
        // Base Condition
        if (n == 0) return;
        System.out.print(n + " ");
        //Induction
        print_n_1(n - 1); // Think: --n works but n-- will not work, infinite loop
    }

    public static int nthFactorial(int n) {
        // Base
        if (n == 0 || n == 1) return 1;
        return n * nthFactorial(n - 1);
    }

    public static int nthFibonacci(int n) {
        // Base Condition
        if (n == 1 || n == 2) return 1;
        // Induction
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    public static int nthFibonacci_improved(int n, int[] mem) {
        if (n == 1 || n == 2) mem[n] = 1;
        if (mem[n] == 0) mem[n] = nthFibonacci_improved(n - 1, mem) + nthFibonacci_improved(n - 2, mem);
        return mem[n];
    }

    public static void sortArray_recursive(int[] a) {
        if (a == null || a.length == 0) return;
        sortArray_recursive(a, a.length - 1);
    }

    private static void sortArray_recursive(int[] a, int n) {
        if (n == 0) return;
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            if (a[i] > a[idx]) idx = i;
        }
        int t = a[idx];
        a[idx] = a[n];
        a[n] = t;
        sortArray_recursive(a, n - 1);
    }

    public static void sort_stack(Stack<Integer> stack) {
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

    public static void sort_stack_recursive(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) temp.push(stack.pop());
        sort_stack_recursive(stack, temp);
    }

    private static void sort_stack_recursive(Stack<Integer> stack, Stack<Integer> temp) {
        if (temp.isEmpty()) return;
        if (stack.isEmpty() || temp.peek() >= stack.peek()) stack.push(temp.pop());
        else {
            int t = temp.pop();
            while (!stack.isEmpty() && t < stack.peek()) temp.push(stack.pop());
            stack.push(t);
        }
        sort_stack_recursive(stack, temp);
    }

    public static void deleteMiddle(Stack<Integer> stack) {
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

    public static void main(String[] args) {
        int n = 9;
        print_1_n(n);
        System.out.println();
        print_n_1(n);
        System.out.println("\nFactorial(" + n + ") = " + nthFactorial(n));
        System.out.println("Fibonacci(" + n + ") = " + nthFibonacci(n));
        System.out.println("[Memoization] Fibonacci(" + n + ") = " + nthFibonacci_improved(n, new int[n + 1]));
        int[] a = {7, 9, 6, 10, 5, 1, 8, 7, 0};
        System.out.println("Array = " + Arrays.toString(a));
        sortArray_recursive(a);
        System.out.println("Sorted = " + Arrays.toString(a));
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(4);
        stack.push(0);
        stack.push(9);
        stack.push(2);
        System.out.println("Stack = " + stack);
        sort_stack(stack);
        System.out.println("Sorted = " + stack);

        stack = new Stack<>();
        stack.push(8);
        stack.push(10);
        stack.push(0);
        stack.push(10);
        stack.push(2);
        stack.push(-1);
        System.out.println("Stack = " + stack);
        sort_stack_recursive(stack);
        System.out.println("[Recursive] Sorted = " + stack);

        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack = " + stack);
        deleteMiddle(stack);
        System.out.println("Delete Middle = " + stack);
        deleteMiddle(stack);
        System.out.println("Delete Middle = " + stack);
    }
}
