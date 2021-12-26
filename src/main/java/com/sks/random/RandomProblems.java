package com.sks.random;

import java.util.*;

public class RandomProblems {

    public static void main(String[] args) {
        Integer[] a = {5, 8, 1, 3, 4};
        List<Integer> l = Arrays.asList(a);
        System.out.println("list = " + l);
        Collections.sort(l);
        System.out.println("list = " + l);
        //others();
    }

    public static void others() {
        List<LinkedList<String>> ht = new ArrayList<LinkedList<String>>();

        StringBuilder sb = new StringBuilder();
        sb.append("John");
        sb.append("is");
        sb.append("Boss");

        System.out.println(sb.indexOf("is"));
    }
}
