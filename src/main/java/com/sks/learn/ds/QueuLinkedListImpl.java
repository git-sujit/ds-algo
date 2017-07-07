package com.sks.learn.ds;

public class QueuLinkedListImpl implements QueueInterface {
	private class Node {
		Object item;
		Node next;

		@Override
		public String toString() {
			return item.toString();
		}
	}

	private Node first;
	private Node last;
	int size;

	@Override
	public void enqueue(Object obj) {
		Node n = new Node();
		n.item = obj;
		if (first == null) {
			first = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
		size++;
		System.out.println("Enqued : "+obj);
	}

	@Override
	public Object dequeu() {
		if (first == null) {
			System.out.println("Queue is Empty");
			return null;
		}
		Node temp = first;
		first = first.next;
		System.out.println("Dequed : "+temp);
		size--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printQueueContent() {
		Node temp = first;
		System.out.print("\nQueuContent = [");
		while (temp != null) {
			System.out.print(temp);
			temp = temp.next;
			if (temp != null) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");
	}

}
