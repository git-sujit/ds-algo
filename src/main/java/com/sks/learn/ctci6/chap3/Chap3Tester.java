package com.sks.learn.ctci6.chap3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Chap3Tester {

	public static void main(String[] args) throws Exception {
		Chap3Implementation obj = new Chap3Implementation();

		Deque<Integer> stack = prepareRandomStack();
		System.out.println("Stack size = " + stack.size());
		printStack(stack);
		System.out.println("After Sorting");
		obj.sortStack(stack);
		printStack(stack);
		System.out.println("Stack size = " + stack.size());

	}

	private static Deque<Integer> prepareRandomStack() {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(8);
		stack.push(1);
		stack.push(12);
		stack.push(9);
		stack.push(14);
		return stack;
	}

	private static void printStack(Deque<Integer> stack) {
		Deque<Integer> temp = new ArrayDeque<Integer>();
		while (!stack.isEmpty()) {
			int s = stack.pop();
			temp.push(s);
			System.out.println(s + " ");
		}
		// Restore Stack from Temp
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
	}

	private static void prev() throws Exception {
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
