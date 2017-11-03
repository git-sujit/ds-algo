package com.sks.learn.ctci6.chap3;

public class MyQueue<T> {
	private QueueNode<T> start;
	private QueueNode<T> end;

	public void enqueue(T data) {
		QueueNode<T> node = new QueueNode<T>();
		node.setData(data);
		if (start == null || end == null) {
			start = node;
			end = node;
		} else {
			end.setNext(node);
		}
	}

	public T dequeue() throws Exception {
		if (start == null || end == null) {
			throw new Exception("Queueu is empty");
		}
		QueueNode<T> temp = start;
		start = start.getNext();
		return temp.getData();
	}

}
