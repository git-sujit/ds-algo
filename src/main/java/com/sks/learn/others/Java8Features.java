/**
 * MAJOR RELEASES IN JAVA:
 * 		1.0 in 1996(more than 20 years back)
 * 		1.2
 * 		1.5: Generics, Enums, AutoBoxing
 * 		1.8
 * RATIONAL BEHIND JAVA: 1.8:
 * 		- To use benefits of functional programming: Java is object oriented programming (Lambda Expression) 
 * 		- To enable parallel processing in Java- To utilize multi-core of CPU (Stream API)
 * @author Sujit
 *
 */
package com.sks.learn.others;

import java.util.LinkedList;
import java.util.List;

public class Java8Features {

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		l.add(9);
		System.out.println(l.get(0));
		learnLamdaExpression();

	}

	/**
	 * Based on Lambda Calculus First Used in LISP Languages Use Lambda Expression:
	 * C, C++, Objective C, C#, .net, Scala, Ruby, Python
	 * 
	 */
	MyLambda doubleIt = (int i) -> 2 * i;

	public static void learnLamdaExpression() {
		MyLambda doubleIt = (int i) -> 2 * i;
	}

	public static void learnFunctionalInterfaces() {

	}

	public static void learnStreamAPI() {

	}

	public static void learnDefaultMethodsInInterface() {

	}

	public static void learnStaticMethodInInterface() {

	}

	public static void learnPredefinedFunctionalInterfaces() {

	}

	public static void learnDoubleColonOperator() {

	}

	public static void learnJodaTimeAPI() {

	}
}

interface MyLambda {
	int m1(int i);
}
