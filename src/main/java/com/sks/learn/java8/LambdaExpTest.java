package com.sks.learn.java8;

public class LambdaExpTest {

	public static void main(String[] args) {
		print();
		sum(8, 9);
		() -> {System.out.println("Hellow to Lambda World!!!");}
	}

	public static void print() {
		System.out.println("Hellow to Lambda World!!!");
	}

	public static void sum(int i1, int i2) {
		System.out.println("sum = " + (i1 + i2));
	}
}
