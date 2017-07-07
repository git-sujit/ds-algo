package com.sks.learn.ds;

/**
 * @author Sujit K Singh
 *
 */
public class QueueArrayImpl implements QueueInterface {
	Object[] array = new Object[1];
	int firstIndex = -1;
	int lastIndex = -1;

	@Override
	public void enqueue(Object obj) {
		if (isEmpty()) {
			array[firstIndex] = obj;
			array[lastIndex] = obj;
		} else {
			// Resize the Queue if needed
			int currentCapacity = array.length;
			if (currentCapacity == lastIndex + 1) {
				if (firstIndex > 0) {
					int j = 0;
					for (int i = firstIndex; i < currentCapacity; i++, j++) {
						array[j] = array[i];
					}
					firstIndex = 0;
					lastIndex = j--;
				} else {
					resize(2 * currentCapacity);
				}
			}
			array[lastIndex + 1] = obj;
		}

	}

	@Override
	public Object dequeu() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		}
		// Resize the Queue if needed
		int currentCapacity = array.length;
		if (currentCapacity == firstIndex + 1) {
			if(firstIndex > 0){
				
			}
		}
		Object temp = array[firstIndex];
		firstIndex += 1;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		if (firstIndex < 0) {
			return 0;
		}
		return lastIndex - firstIndex + 1;
	}

	@Override
	public void printQueueContent() {
		// TODO Auto-generated method stub

	}

	private void resize(int capacity) {
		Object[] nextArray = new Object[capacity];
		int currentCapacity = array.length;
		for (int i = 0; i < currentCapacity; i++) {
			nextArray[i] = array[i];
		}
	}
}
