package com.sks.interview.interview2018;

public class Others {

	public static void main(String[] args) {
		System.out.println("Result = " + method(0));
	}

	public static int method(int n) {
		System.out.println("method(" + n + ")");
		if (n == 10) {
			return n += n;
		} else {
			if (n == 7) {
				return 7;
			}
			return method(n + 1);
		}
	}

}
