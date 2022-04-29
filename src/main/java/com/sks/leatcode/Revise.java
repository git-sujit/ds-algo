package com.sks.leatcode;

import java.util.*;
import java.util.stream.Collectors;

public class Revise {
    private static void bitwiseOperator() {
        int n = 81;
        String s = Integer.toBinaryString(n);
        System.out.println("Number  " + n + ", Binary String = " + binaryString(n) + " Java = " + s);
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            //System.out.println(n & mask);
            mask <<= 1;
        }
    }

    private static String binaryString(int n) {
        if (n == 0) return "";
        return binaryString(n / 2) + n % 2;
    }

    private static void comparators() {
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator
                .comparing(String::length)
                .thenComparing(String::toString));

        PriorityQueue<String> minHeap = new PriorityQueue<>();
        minHeap.add("Sujit");
        minHeap.add("K");
        minHeap.add("Singh");
        int i = 0;
        String[] out = new String[minHeap.size()];
        for (String s : minHeap)
            out[i++] = s;
        System.out.println("out = " + Arrays.toString(out));
    }

    private static void map() {
        /**getOrDefault: for primitive
         * computeIfAbsent: for Object lke list*/
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(1, m1.getOrDefault(1, 0) + 1);
        System.out.println("m1 = " + m1);
        Map<Integer, List<Integer>> m2 = new HashMap<>();
        //Java-8: new default method computeIfAbsent of the Map interface
        //default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
        //mapping function is only called if the mapping is not present
        //Firstly, it checks if the key is present in the map. If the key is present and a non-null value is related to the key, then it returns that value
        //if the key is not present in the map or null value is related to the key, then it attempts to compute the value using the given mappingFunction
        //Also, if the mappingFunction returns null, the map records no mapping
        //if the mappingFunction throws an unchecked exception, then the exception is re-thrown, and the map records no mapping
        m2.computeIfAbsent(1, e -> new ArrayList<>()).add(11);
        System.out.println("m2 = " + m2);
        m2.computeIfAbsent(1, e -> new ArrayList<>()).add(111);
        System.out.println("m2 = " + m2);
        List<Integer> value = m2.getOrDefault(2, new ArrayList<>());
        value.add(22);
        m2.put(2, value);
        //m.put(2, e->m.getOrDefault(2).add(222));
        // Wrong:: m.put(2, m.get(2).add(222));
        System.out.println("Map = " + m2);
    }

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
        /**
         * primitive array to List
         */
        // Creating and Initializing array in one-line
        int[] a = {1, 2, 3};
        // Array to List: We need to box to Integer[]
        List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
        // If we have Integer[] then no need to box
        Integer[] a1 = {1, 2, 3};
        System.out.println("Before, array = " + Arrays.toString(a1));
        List<Integer> l1 = Arrays.asList(a1);
        a1[0]++;
        System.out.println("After, array = " + Arrays.toString(a1));
        /**
         * List to primitive array
         */
        int[] la = l.stream().mapToInt(i -> i).toArray();
        /**
         * Sort int[][]
         */
        int[][] intervals = {{15, 18}, {1, 3}, {2, 6}, {8, 10}};
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        /**
         * List of array to 2D array
         */
        List<int[]> out = new ArrayList<>();
        out.add(new int[]{1, 2});
        out.add(new int[]{4, 8});
        out.add(new int[]{7, 9});
        int[][] outArr = out.toArray(new int[out.size()][]);
        System.out.println("outArr = " + Arrays.deepToString(outArr));

        /**
         * Removing element from List
         * remove(int index) vs remove(Obj)
         */
        List<Integer> lst = Arrays.asList(new Integer[]{10, 20, 30, 40});
        // Removes element at index-0
        lst.remove(0);
        // Removes element with value 10
        lst.remove((Integer) 40);
    }

    private static void stringUtilities() {
        // Reverse a string
        String s = "sujit kumar singh";
        String r = new StringBuilder(s).reverse().toString();
        System.out.println("s = " + s + ", r = " + r);
        char[] carr = s.toCharArray();
        String r1 = "";
        for (int i = carr.length - 1; i >= 0; i--)
            r1 += carr[i];
        System.out.println("r1 = " + r1);
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
        stringUtilities();
        //heap();
        array();
        //map();
        //comparators();
        //bitwiseOperator();
    }
}
