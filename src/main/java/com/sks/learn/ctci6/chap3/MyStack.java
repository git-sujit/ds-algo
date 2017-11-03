package com.sks.learn.ctci6.chap3;

public class MyStack<T> {
	private StackNode<T> top;

	public void push(T data) {
		StackNode<T> node = new StackNode<T>();
		node.setData(data);
		node.setNext(top);
		top = node;
	}

	public T pop() throws Exception {
		if (top == null)
			throw new Exception("Empty Stack");
		StackNode<T> temp = top;
		top = top.getNext();
		return temp.getData();
	}

	public StackNode<T> peek() throws Exception {
		if (top == null)
			throw new Exception("Empty Stack");
		return top;
	}

	public void printStack(MyStack<T> s) {
		if (s != null) {
			StackNode<T> top = s.top;
			while (top != null) {
				System.out.println(top.getData());
				top = top.getNext();
			}
		}

	}
}
