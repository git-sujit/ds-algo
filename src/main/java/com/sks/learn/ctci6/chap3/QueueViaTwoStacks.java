package com.sks.learn.ctci6.chap3;

import java.util.Stack;

public class QueueViaTwoStacks<T> {
	Stack<T> s1 = new Stack<T>();
	Stack<T> s2 = new Stack<T>();

	public void enqueue(T data) {
		if (s1.isEmpty() && s2.isEmpty()) {
			s1.push(data);
			System.out.println("s1.isEmpty()="+s1.isEmpty()+", s2.isEmpty()="+s2.isEmpty());
			return;
		}
		if (s1.isEmpty()) {
			s1.push(data);
			System.out.println("Pushing to s1:"+data);
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		else if (s2.isEmpty()) {
			s2.push(data);
			System.out.println("Pushing to s2:"+data);
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		System.out.println("s1.isEmpty()="+s1.isEmpty()+", s2.isEmpty()="+s2.isEmpty());
	}

	public T dequeue() throws Exception {
		if (s1.isEmpty() && s2.isEmpty())
			throw new Exception("Queue is empty");
		if (s1.isEmpty()) {
			return s2.pop();
		}
		if (s2.isEmpty()) {
			return s1.pop();
		}
		return null;
	}

	public void printQueue() {
		System.out.println("PRINTING...");
		if (s1.isEmpty() && s2.isEmpty()) {
			return;
		}
		if (s1.isEmpty()) {
			s2.forEach(item -> System.out.println("s2: " + item));
		}
		if (s2.isEmpty()) {
			s1.forEach(item -> System.out.println("s1: " + item));
		}
	}
}
