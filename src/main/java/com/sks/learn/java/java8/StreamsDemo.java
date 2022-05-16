package com.sks.learn.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * COLLECTION INTERFACE HAS DEFAULT INTERFACE METHOD: stream()
 * To process objects inside the collection(List, Set, Map)
 * Collection_Object.streams() => returns object of java.util.Stream class
 * Stream has two methods:
 * - filter() : Filter collection based on boolean condition(Predicate functional interface)
 * - map() : Create new object for each object in collection(Function<T,R> functional interface)
 * - sorted() or sorted(Comparator):  sort elements inside stream, you can mention custom comparator, DOES NOT SORT ORIGINAL COLLECTION
 * - min(Comparator) : minimum value in stream
 * - max(Comparator) : maximum value in stream
 * - forEach() : no return, but applies lambda expression to each element: Changes the Collection
 * - toArray() : copy element in Stream to array
 * <p>
 * Stream.of() - for getting stream for any group of object including array
 * <p>
 * METHODS OF java.util.Stream class:
 * - collect(): process objects from stream and adds to specified collection
 * - count(): returns the count
 */
public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(10, 40, 50, 20, 30, 75, 80, 94, 32, 76, 15, 58, 13);
        filterDemo(lst);
        mapDemo(lst);
        sortDemo(lst);
        minMax(lst);
        forEachDemo(lst);
        toArrayDemo(lst);
        streamOfDemo();
    }

    private static void streamOfDemo() {
        System.out.println("\n*** Demo: Streams.of()");
        Stream<Integer> stm = Stream.of(9, 99, 999, 9999, 9999);
        stm.forEach(e -> System.out.print(e + "\t"));
        Double[] darr = {10.0, 10.45, 17.65, 89.34, 87.45, 12.87};
        System.out.println();
        Stream<Double> stmD = Stream.of(darr);
        stmD.forEach(e -> System.out.print(e + "\t"));
    }

    private static void toArrayDemo(List<Integer> lst) {
        System.out.println("\n*** Demo: streams.toArray() \nList = " + lst + ", size = " + lst.size());
        Integer[] out = lst.stream().toArray(Integer[]::new);
        System.out.println("Int Array = " + Arrays.toString(out));
    }

    private static void forEachDemo(List<Integer> lst) {
        System.out.println("\n*** Demo: streams.forEach() \nList = " + lst + ", size = " + lst.size());
        lst.forEach(e -> System.out.print(e + "\t"));
        lst.forEach(System.out::print); //Method Reference
    }

    private static void minMax(List<Integer> lst) {
        System.out.println("\n*** Demo: streams.min/max() \nList = " + lst + ", size = " + lst.size());
        int min1 = lst.stream().min(Comparator.naturalOrder()).get();
        int min2 = lst.stream().min(Comparator.reverseOrder()).get();
        System.out.println("min1 = " + min1 + ", min2 = " + min2);
        int max1 = lst.stream().max(Comparator.naturalOrder()).get();
        int max2 = lst.stream().max(Comparator.reverseOrder()).get();
        System.out.println("max1 = " + max1 + ", max2 = " + max2);
    }

    private static void sortDemo(List<Integer> lst) {
        System.out.println("\n*** Demo: streams.sorted() \nList = " + lst + ", size = " + lst.size());
        List<Integer> sortedLst = lst.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List = " + sortedLst);
        List<Integer> revSortedLst = lst.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Reverse Sorted List = " + revSortedLst);
    }

    private static void filterDemo(List<Integer> lst) {
        System.out.println("\n*** Demo: streams.filter() \nList = " + lst + ", size = " + lst.size());
        List<Integer> evenLst = lst.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Even List = " + evenLst + ", count = " + lst.stream().filter(i -> i % 2 == 0).count());
        List<Integer> oddLst = lst.stream().filter(i -> i % 2 == 1).collect(Collectors.toList());
        System.out.println("Odd List = " + oddLst + ", count = " + lst.stream().filter(i -> i % 2 == 1).count());
    }

    private static void mapDemo(List<Integer> lst) {
        System.out.println("\n*** Demo: streams.map() \nList = " + lst + ", size = " + lst.size());
        List<Integer> doubleLst = lst.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println("Double List = " + doubleLst);
    }
}
