package com.sks.learn.algo.utility;

public class MathFunctions {

	public static void main(String[] args) {
		System.out.println("factorial(4) = "+factorial_recursive(5));

	}
	public static int factorial_recursive(int n){
		if(n==0){
			return 1;
		}
		return n*factorial_recursive(n-1);
	}
}
