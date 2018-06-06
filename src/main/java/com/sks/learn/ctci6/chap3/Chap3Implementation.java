package com.sks.learn.ctci6.chap3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Chap3Implementation implements Chap3Contract {

	@Override
	public void oneArrayThreeStack() {

	}

	@Override
	public void queueViaTwoStacks() {
		QueueViaTwoStacks<String> qvs = new QueueViaTwoStacks<String>();
		qvs.enqueue("a");
		qvs.printQueue();
		qvs.enqueue("b");
		qvs.printQueue();
		qvs.enqueue("c");
		qvs.printQueue();
		qvs.enqueue("d");
		qvs.printQueue();
	}

	public static void main(String[] args) {
		Chap3Contract ctr = new Chap3Implementation();
		ctr.queueViaTwoStacks();
	}

	@Override
	public void sortStack(Deque<Integer> stack) {
		if (stack == null || stack.isEmpty())
			return;
		Deque<Integer> temp = new ArrayDeque<Integer>();
		// Initialize temp;
		temp.push(stack.pop());
		while (!stack.isEmpty()) {
			int s1 = stack.peek();
			while (!temp.isEmpty() && temp.peek() > s1) {
				stack.push(temp.pop());
			}
			// Push the element
			temp.push(s1);
			while (true) {
				int s = stack.pop();
				if (s == s1) {
					break;
				}
				temp.push(s);
			}
		}
		// Temp is in reverse order now
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}

	}
}
