package com.sks.learn.dsalgo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.sks.learn.algo.QuickFindUF;
import com.sks.learn.algo.QuickFindUF.QFData;
import com.sks.learn.algo.QuickUnion;
import com.sks.learn.algo.UnionFind;
import com.sks.learn.ds.QueuLinkedListImpl;
import com.sks.learn.ds.QueueInterface;
import com.sks.learn.ds.StackArrayImpl;
import com.sks.learn.ds.StackInterface;
import com.sks.learn.ds.StackLinkedListImpl;

public class MiscTester {

	@Test
	public void testUnionFind() {
		UnionFind uf = new UnionFind();
		assertFalse(uf.isConnected(10, 11));
		uf.union(10, 11);
		assertTrue(uf.isConnected(10, 11));
		uf.union(13, 14);
		uf.union(18, 20);
		uf.union(10, 15);
		uf.union(17, 13);
		uf.union(10, 12);
		assertTrue(uf.isConnected(13, 17));
		assertTrue(uf.isConnected(10, 15));
		assertFalse(uf.isConnected(15, 20));
	}

	@Test
	public void testQuickFind() {
		QuickFindUF qf = new QuickFindUF(10);
		List<QFData> qfDataList = qf.getQfDataList();
		qf.union(qfDataList.get(0), qfDataList.get(1));
		assertTrue(qf.isConnected(qfDataList.get(0), qfDataList.get(1)));
		qf.union(qfDataList.get(2), qfDataList.get(4));
		qf.union(qfDataList.get(6), qfDataList.get(8));
		qf.union(qfDataList.get(1), qfDataList.get(3));
		qf.union(qfDataList.get(5), qfDataList.get(7));
		qf.union(qfDataList.get(9), qfDataList.get(0));
		assertTrue(qf.isConnected(qfDataList.get(1), qfDataList.get(9)));
	}

	@Test
	public void testQuickUnion() {
		QuickUnion qu = new QuickUnion(10);
		qu.union(4, 3);
		qu.union(3, 8);
		qu.union(6, 5);
		qu.union(9, 4);
		qu.union(5, 0);
	}

	@Test
	public void testStack_LinkedList() {
		System.out.println("************** STACK :: LINKED LIST IMPLEMENTATION **************");
		StackInterface s = new StackLinkedListImpl();
		assertTrue(s.isEmpty());
		s.push("1");
		s.printStackContent();
		s.push("2");
		s.printStackContent();
		s.push("3");
		s.printStackContent();
		System.out.println(s.peek());
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
		s.push("5");
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
		System.out.println(s.peek());
		s.printStackContent();
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
	}
	@Test
	public void testStack_Array() {
		System.out.println("************** STACK :: ARRAY IMPLEMENTATION **************");
		StackInterface s = new StackArrayImpl();
		assertTrue(s.isEmpty());
		s.push("1");
		s.printStackContent();
		s.push("2");
		s.printStackContent();
		s.push("3");
		s.printStackContent();
		System.out.println(s.peek());
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
		s.push("5");
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
		System.out.println(s.peek());
		s.printStackContent();
		s.printStackContent();
		System.out.println(s.pop());
		s.printStackContent();
	}
	
	@Test
	public void testQueue_Array() {
		System.out.println("************** QUEUE :: LINKED LIST IMPLEMENTATION **************");
		QueueInterface q = new QueuLinkedListImpl();
		assertTrue(q.isEmpty());
		q.enqueue("1");
		q.printQueueContent();
		q.enqueue("2");
		q.printQueueContent();
		q.enqueue("3");
		q.printQueueContent();
		System.out.println("size = "+q.size());
		System.out.println(q.dequeu());
		q.printQueueContent();
		q.enqueue("5");
		q.printQueueContent();
		System.out.println("size = "+q.size());
		System.out.println(q.dequeu());
		q.printQueueContent();
		System.out.println(q.dequeu());
		q.printQueueContent();
		System.out.println("size = "+q.size());
	}
	
}
