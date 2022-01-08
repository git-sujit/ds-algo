package com.sks.learn.ds;

import java.util.*;

public class JavaOOTB_DS {

	public static void main(String[] args) {
		// demoOOTB_Vector();
		// demoOOTB_Stack();
		// demoOOTB_StackDeque();
		// demoOOTB_Queue();
		List<Integer> i = new ArrayList<Integer>();
		i.add(1);
		i.add(2);
		i.add(3);
		System.out.println("Before - " + i);
		refCheck(i);
		System.out.println("After - " + i);
	}

	public static void refCheck(List<Integer> i) {
		//List<Integer> i1 = i;
		//i1.add(10000);
		//System.out.println("Inside - " + i1);
		i = new ArrayList<Integer>();
		i.add(9);
		System.out.println("Inside - " + i);

	}

	/**
	 * Concrete Class: Stack / But Use Deque<br>
	 * Last-in-first-out (LIFO) stack of objects <br>
	 * It extends class Vector with five operations that allow a vector to be
	 * treated as a stack <br>
	 * A more complete and consistent set of LIFO stack operations is provided
	 * by the Deque interface <br>
	 */
	public static void demoOOTB_Stack() {
		// Class Stack
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.isEmpty());
		// Stack-push
		stack.push(1);
		stack.push(2);
		stack.push(3);
		// Stack- Size/Empty
		stack.size();
		System.out.println(stack.isEmpty());
		// Stack-peek
		System.out.println(stack.peek());
		// Stack-pop
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

	/**
	 * Interface: Deque(double ended queue/deck)- insertion and removal at both
	 * ends <br>
	 * Why Deque is better than Stack(Consistency & Interface Based design of
	 * Deque) <br>
	 * 1. Stack-Class has no interface and extends Synchronized Vector class
	 * (Concrete class based design- Not good) <br>
	 * 2. Stack-class is only having Array implementation (Thru Vector) <br>
	 * 3. Deque is interface and we have array-based implementation(ArrayDeque)
	 * and LinkedList implementation (LinkedList): (Interface based design-
	 * Good) <br>
	 * 4. Deque is more CONSISTENT than Stack: Deque exposes a set of operations
	 * which is all about being able to fetch/add/remove items from the start or
	 * end of a collection, iterate etc - and that's it. There's deliberately no
	 * way to access an element by position, which Stack exposes because it's a
	 * subclass of Vector. <br>
	 * ArrayDeque(Java-6) Vs LinkedList: ArrayDeque is memory efficient <br>
	 * Accessing Element: <br>
	 * ArrayDeque: O(1)<br>
	 * LinkedList: O(n)<br>
	 */
	public static void demoOOTB_StackDeque() {
		// Array Based Implementation
		System.out.println("Deque: Array Based Implementation");
		Deque<Integer> stack = new ArrayDeque<Integer>();
		// Stack operations
		System.out.println(stack.isEmpty());
		// Stack-push
		stack.push(1);
		stack.push(2);
		stack.push(3);
		// Stack- Size/Empty
		stack.size();
		System.out.println(stack.isEmpty());
		// Stack-peek
		System.out.println(stack.peek());
		// Stack-pop
		System.out.println(stack.pop());
		System.out.println(stack.peek());

		// LinkedList Based Implementation
		System.out.println("Deque: LinkedList Based Implementation");
		Deque<Integer> stack1 = new LinkedList<Integer>();
		// Stack operations
		System.out.println(stack1.isEmpty());
		// Stack-push
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		// Stack- Size/Empty
		stack1.size();
		System.out.println(stack1.isEmpty());
		// Stack-peek
		System.out.println(stack1.peek());
		// Stack-pop
		System.out.println(stack1.pop());
		System.out.println(stack1.peek());
	}

	/**
	 * Queue: First In First Out behavior <br>
	 * Queue Interface: Implemented by LinkedList & PriorityQueue <br>
	 * The PriorityQueue class is a priority queue based on the priority and
	 * heap data structure so that Highest Priority element is at the root of
	 * heap <br>
	 * We know that Queue follows First-In-First-Out model but sometimes we need
	 * to process the objects in the queue based on the priority. That is when
	 * Java PriorityQueue is used.<br>
	 * The difference between PriorityQueue and Linkedlist is at the time of
	 * insertion PriorityQueue will be sorted as well as Ordered as per the
	 * natural Order but we can add a Comparator also in order to define the
	 * particular order of sorting for a record, while as LinkedList will be
	 * Just Ordered. So while you are trying to add elements in PriorityQueue,
	 * they will get sorted on the basis of their natural order or as per the
	 * comparator function<br>
	 * NOTE: LinkedList implements List, Deque & Queue interface so it can
	 * behave as both Stack and Queue<br>
	 */
	public static void demoOOTB_Queue() {
		// Linked List Based Implementation
		System.out.println("Queue: LinkedList Based Implementation");
		Queue<Integer> queue = new LinkedList<Integer>();
		System.out.println(queue.isEmpty());
		// Enqueue
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.size());
		// Remove- Both Poll & remove(), removes the head of the queue
		System.out.println("poll=" + queue.poll());
		System.out.println("peek=" + queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.size());
		// Linked List Based Implementation
		System.out.println("Queue: PriorityQueue Based Implementation");
		Queue<Integer> queue1 = new PriorityQueue<Integer>();
		System.out.println(queue1.isEmpty());
		// Enqueue
		queue1.add(1);
		queue1.add(2);
		queue1.add(3);
		System.out.println(queue1.size());
		// Remove- Both Poll & remove(), removes the head of the queue
		System.out.println("poll=" + queue1.poll());
		System.out.println("peek=" + queue1.peek());
		System.out.println(queue1.remove());
		System.out.println(queue1.size());
	}

	public static void demoOOTB_BinaryTree() {

	}

	public static void demoOOTB_Heap() {

	}

	/**
	 * Concrete Class: Vector<E> <br>
	 * Implements Collection<E>, List<E>, RandomAccess <br>
	 * Can be accessed using an integer index: O(1) <br>
	 * Growable array: size of a Vector can grow or shrink as needed <br>
	 * Synchronized <br>
	 * Use ArrayList if a thread-safe implementation is not needed <br>
	 */
	public static void demoOOTB_Vector() {
		Vector<Integer> v = new Vector<Integer>();
		// Adding element
		v.add(1);
		v.add(2);
		v.add(3);
		// Removing element
		v.remove(0);
		v.remove(5);
		// Random access
		System.out.println(v.get(0));
		System.out.println(v.contains(2));
		System.out.println(v.elementAt(0));
		System.out.println(v.size());
		v.removeAllElements();
		System.out.println(v.capacity());
		// Stack operations
	}
}
