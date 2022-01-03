package com.sks.leatcode;

import java.util.*;
import java.util.stream.Collectors;

public class Revise {
    private static void heap() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(10);
        minHeap.add(3);
        System.out.println("Min Heap = " + minHeap);
        minHeap.add(15);
        minHeap.add(7);
        System.out.println("Min Heap = " + minHeap);
        minHeap.add(1);
        System.out.println("Min Heap = " + minHeap);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(7);
        System.out.println("\nMax Heap = " + maxHeap);
        maxHeap.add(10);
        System.out.println("Max Heap = " + maxHeap);
        maxHeap.add(5);
        System.out.println("Max Heap = " + maxHeap);
        maxHeap.add(20);
        System.out.println("Max Heap = " + maxHeap);

        // Using pair of data
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>();
        pq.add(new AbstractMap.SimpleEntry<>(1, 6));
    }

    private static void array() {
        // Creating and Initializing array in one-line
        int[] a = {1, 2, 3};

        // Array to List: We need to box to Integer[]
        List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
        // If we have Integer[] then no need to box
        Integer[] a1 = {1, 2, 3};
        List<Integer> l1 = Arrays.asList(a1);


        // List to Array

        // Sort an Array: Modifies the array
        // Quick Sort, Time- O(nlogn), Space- O(logn)
        Arrays.sort(a1);

    }

    private static void stringUtilities() {
        // Reverse a string
        String s = "sujit kumar singh";
        String r = new StringBuilder(s).reverse().toString();
        System.out.println("s = " + s + ", r = " + r);
    }

    private static void array_of_primitive_to_object() {
        // Compilation error: That's because autoboxing only applies to individual elements and not to arrays or collections
        // Integer[] integers = (Integer[])(new int[]{0,1,2,3,4});
        int[] input = new int[]{0, 1, 2, 3, 4};
        // Primitive Array -> Object Array
        Integer[] output = Arrays.stream(input).boxed().toArray(Integer[]::new);

        // Object Array -> Primitive Array
        int[] output1 = Arrays.stream(output).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Stack is concrete class in java
     * push/pop/peek/empty/size are supported
     */
    private static void stackInJava() {
        System.out.println("####### STACK ##########");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(100);
        System.out.println(stack);
        System.out.println("peek : " + stack.peek());
        stack.pop();
        System.out.println("LIFO, After pop: " + stack);
        System.out.println("is Empty? : " + stack.empty());
        System.out.println("Size = " + stack.size());
    }

    /**
     * Queue is interface in java, LinkedList implements it
     * add/remove/isEmpty/peek is supported
     */
    private static void queueInJava() {
        System.out.println("####### QUEUE ##########");
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(100);
        System.out.println(q);
        System.out.println("peek : " + q.peek());
        q.remove();
        System.out.println("FIFO, After remove: " + q);
        System.out.println("is Empty? : " + q.isEmpty());
        System.out.println("Size = " + q.size());
    }

    public static void main(String[] args) {
        //stackInJava();
        //queueInJava();
        //stringUtilities();
        heap();
    }
}
