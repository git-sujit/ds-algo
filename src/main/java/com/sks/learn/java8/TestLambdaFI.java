package com.sks.learn.java8;

import java.util.ArrayList;
import java.util.List;

public class TestLambdaFI {
	public static void main(String[] str) {
		// Traditional Way
		MyFI fi = new MyFIimpl();
		System.out.println(fi.sum(3, 5));

		// Thru Lambda Expression
		MyFI fi1 = (a, b) -> a + b;
		System.out.println(fi1.sum(3, 5));

		// Lambda Expression
		List<Integer> lst = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			lst.add(i);
		}
		MyFI_1 fi2 = t -> {
			for (int i : t) {
				System.out.print(i + " ");
			}
		};
		
		fi2.iterateAndPrint(lst);
	}
}

class MyFIimpl implements MyFI {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

}

/*
 * How: Annnotate an interface with Functional Interface and write Only one
 * abstract method It can have default or static method but must have only one
 * abstract method Prio-to Java-8(Similar Interfaces): Runnable & Comparable
 * interfaces Why:For Lambda expression (so that we can pass single method of
 * Functional Interface as anonymous class
 */
@FunctionalInterface
interface MyFI {
	int sum(int a, int b);

	/*
	 * Why Default Method: Backward compatibility and API extension so that old
	 * interfaces can be used to leverage the lambda expression capability of
	 * Java 8 For example, ‘List’ or ‘Collection’ interfaces do not have
	 * ‘forEach’ method declaration. Thus, adding such method will simply break
	 * the collection framework implementations. Java 8 introduces default
	 * method so that List/Collection interface can have a default
	 * implementation of forEach method, and the class implementing these
	 * interfaces need not implement the same.
	 */
	default public void myDefaultMethod_1(int i) {
		System.out.println("FIRST: Parameter passed is: " + i);
	}

	default public void myDefaultMethod_2(int i) {
		System.out.println("SECOND: Parameter passed is: " + i);
	}

	default public void myDefaultMethod_3(int i) {
		System.out.println("THIRD: Parameter passed is: " + i);
	}

	static void myStaticDefaultMethod(int i) {
		System.out.println("Static Default Method: Parameter passed is: " + i);
	}
}

@FunctionalInterface
interface MyFI_1 {
	void iterateAndPrint(List<Integer> lst);
}
