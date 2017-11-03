package com.sks.learn.ctci6.chap3;

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
}
