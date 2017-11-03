package com.sks.learn.ctci6.chap3;

public class Chap3Tester {

	public static void main(String[] args) throws Exception {
		MyStack<String> s = new MyStack<String>();
		s.push("A");
		s.push("B");
		s.push("C");
		s.push("D");
		s.printStack(s);
		System.out.println("Pop:");
		s.pop();
		s.pop();
		s.printStack(s);
	}

}
