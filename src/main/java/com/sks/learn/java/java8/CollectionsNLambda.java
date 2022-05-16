package com.sks.learn.java.java8;

import java.util.*;

public class CollectionsNLambda {
    public static void main(String[] args) {
        // Sort list/set/map in descending order(Default sorting order is ascending)
        listSorting();
        setSorting();
        mapSorting();
        customSorting();
    }

    private static void customSorting() {
        List<Employee> empList = prepareEmpList();
        Collections.sort(empList, (Employee e1, Employee e2) -> e1.id > e2.id ? 1 : e1.id < e2.id ? -1 : 0);
        System.out.println("Sort Ascending By id => " + empList);

        empList = prepareEmpList();
        Collections.sort(empList, (Employee e1, Employee e2) -> e1.id > e2.id ? -1 : e1.id < e2.id ? 1 : 0);
        System.out.println("Sort Descending By id => " + empList);

        empList = prepareEmpList();
        Collections.sort(empList, (e1, e2) -> e1.name.compareTo(e2.name));
        Collections.sort(empList, Comparator.comparing((Employee e) -> e.name));
        System.out.println("Sort Ascending By name => " + empList);

        empList = prepareEmpList();
        Collections.sort(empList, (e1, e2) -> e2.name.compareTo(e1.name));
        //Collections.sort(empList, Comparator.comparing((Employee e) -> e.name));
        System.out.println("Sort Descending By name => " + empList);
    }

    private static List<Employee> prepareEmpList() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(657, "Sujit"));
        empList.add(new Employee(101, "Amit"));
        empList.add(new Employee(893, "Kumar"));
        empList.add(new Employee(12, "Abhi"));
        empList.add(new Employee(95, "Xue"));
        return empList;
    }

    private static void mapSorting() {
        System.out.println("\nSort Map - Descending");
        int[] a = {19, 14, 10, 54, 9, 0, 13, 65};
        Map<Integer, String> map = new TreeMap<>((i1, i2) -> i1 > i2 ? -1 : i1 < i2 ? 1 : 0);
        for (int n : a) map.put(n, UUID.randomUUID().toString().substring(0, 4));
        System.out.println("[Lambda] Array = " + Arrays.toString(a));
        System.out.println("[Lambda] Descending map = " + map);
    }

    private static void setSorting() {
        System.out.println("\nSort Set - Descending");
        int[] a = {19, 14, 10, 54, 9, 0, 13, 65};
        // Comparator is functional interface so we can replace it with lambda expression to sort in descending order
        Set<Integer> set = new TreeSet<>((i1, i2) -> i1 > i2 ? -1 : i1 < i2 ? 1 : 0);
        for (int n : a) set.add(n);
        System.out.println("[Lambda] Array = " + Arrays.toString(a));
        System.out.println("[Lambda] Descending Set = " + set);
    }

    private static void listSorting() {
        System.out.println("\nSort List - Descending");
        int[] a = {19, 14, 10, 54, 9, 0, 13, 65};
        List<Integer> nums = new ArrayList<>();
        for (int n : a) nums.add(n);
        sortWithoutLambda(nums);
        System.out.println("Array = " + Arrays.toString(a));
        System.out.println("Descending List = " + nums);

        nums = new ArrayList<>();
        for (int n : a) nums.add(n);
        sortWithLambda(nums);
        System.out.println("[Lambda] Array = " + Arrays.toString(a));
        System.out.println("[Lambda] Descending List = " + nums);
    }

    private static void sortWithoutLambda(List<Integer> nums) {
        Collections.sort(nums, new MyComparator());
    }

    private static void sortWithLambda(List<Integer> nums) {
        // Comparator is functional interface so we can replace it with lambda expression
        Collections.sort(nums, (i1, i2) -> i1 > i2 ? -1 : i1 < i2 ? 1 : 0);
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? -1 : o1 < o2 ? 1 : 0;
        }
    }

    static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
