package com.sks.XDEPRECATED.interview2018;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class GenColl {

	public static void main(String[] args) {
		demoSets();
	}

	/**
	 * Common Method across all type of sets<br>
	 * add, remove, size, isEmpty, contains <br>
	 * Java 8/9 : foreach & stream (Functional & Parallel programming)
	 */
	public static void demoSets() {
		// HashSet : Unique, Not Ordered, Not Sorted
		// Data Structure: HashTable
		System.out.println("HashSet Demo");
		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(1);
		s1.add(20);
		s1.add(7);
		s1.add(100);
		s1.add(20);
		System.out.println("s1 contains 1 = " + s1.contains(1));
		s1.remove(1);
		System.out.println("s1 contains 1 = " + s1.contains(1));
		System.out.println("s1 size = " + s1.size());
		System.out.println("s1 isEmpty = " + s1.isEmpty());
		for (Integer i : s1) {
			System.out.println(i);
		}
		// LinkedHashSet: Unique, Ordered By Insertion, Not Sorted
		// Data Structure: HashTable + Doubly Linked List
		System.out.println("LinkedHashSet Demo");
		Set<Integer> s2 = new LinkedHashSet<Integer>();
		s2.add(1);
		s2.add(20);
		s2.add(7);
		s2.add(100);
		s2.add(20);
		System.out.println("s2 contains 1 = " + s2.contains(1));
		s2.remove(1);
		System.out.println("s2 contains 1 = " + s2.contains(1));
		System.out.println("s2 size = " + s2.size());
		System.out.println("s2 isEmpty = " + s2.isEmpty());
		s2.forEach(t -> System.out.print(t + " , "));
		// TreeSet: Unique, Not Ordered, Sorted
		// Data Structure: Red-Black Tree
		System.out.println("TreeSet Demo");
		Set<Integer> s3 = new TreeSet<Integer>();
		s3.add(1);
		s3.add(20);
		s3.add(7);
		s3.add(100);
		s3.add(20);
		System.out.println("s3 contains 1 = " + s3.contains(1));
		s3.remove(1);
		System.out.println("s3 contains 1 = " + s3.contains(1));
		System.out.println("s3 size = " + s3.size());
		System.out.println("s3 isEmpty = " + s3.isEmpty());
		for (Integer i : s3) {
			System.out.println(i);
		}
	}
}
