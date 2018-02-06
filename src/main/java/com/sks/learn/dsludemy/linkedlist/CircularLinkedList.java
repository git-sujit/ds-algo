package com.sks.learn.dsludemy.linkedlist;

/**
 * Usage: Implementation of Queue
 * 
 * Do operations in the end to achieve O(1)
 * 
 * @author ssing69
 *
 */
public class CircularLinkedList {
	SinglyNode last;

	public static void main(String[] args) {
		CircularLinkedList obj = new CircularLinkedList();
		obj.displayCircularList();
	}

	public void displayCircularList() {
		if (this.last == null) {
			System.out.println("Circular List is Empty");
			return;
		}
		SinglyNode p = last;
		while (p.next != last) {
			System.out.println(p.data);
			p = p.next;
		}
	}

	public void insertEmpty(SinglyNode n) {
		if (this.last == null && n != null) {
			this.last = n;
			this.last.next = last;
		}
	}

	public void insertBegining(SinglyNode n) {
		if (last != null && n != null) {
			n.next = this.last.next;
			this.last.next = n;
		}
	}

	public void insertEnd(SinglyNode n) {
		if (this.last != null && n != null) {
			n.next = this.last.next;
			this.last.next = n;
			this.last = n;
		}
	}

	public void insertBefore(SinglyNode n, int x) {
		SinglyNode p = this.last;
		while (p.next.data != x && p.next != this.last) {
			if (p.next == this.last) {
				System.out.println("Not found in list: x = " + x);
			}
			p = p.next;
		}
		n.next = p.next;
		p.next = n;
	}

	public void insertAfter(SinglyNode n, int x) {
		SinglyNode p = this.last;
		while (p.data != x && p.next != this.last) {
			if (p.next == last) {
				System.out.println("Not found in list: x = " + x);
			}
		}
	}

}
