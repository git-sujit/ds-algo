package com.sks.leatcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Revise {
    private void array() {
        // Creating and Initializing array in one-line
        int[] a = {1, 2, 3};

        // Array to List: We need to box to Integer[]
        List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
        // If we have Integer[] then no need to box
        Integer[] a1 = {1, 2, 3};
        List<Integer> l1 = Arrays.asList(a1);

        // List to Array

    }

    private void array_of_primitive_to_object() {
        // Compilation error: That's because autoboxing only applies to individual elements and not to arrays or collections
        // Integer[] integers = (Integer[])(new int[]{0,1,2,3,4});
        int[] input = new int[]{0, 1, 2, 3, 4};
        // Primitive Array -> Object Array
        Integer[] output = Arrays.stream(input).boxed().toArray(Integer[]::new);

        // Object Array -> Primitive Array
        int[] output1 = Arrays.stream(output).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
