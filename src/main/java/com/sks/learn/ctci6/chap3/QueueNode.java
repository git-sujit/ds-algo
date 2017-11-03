package com.sks.learn.ctci6.chap3;

public class QueueNode<T> {
	private T data;
	private QueueNode<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public QueueNode<T> getNext() {
		return next;
	}

	public void setNext(QueueNode<T> next) {
		this.next = next;
	}

}
