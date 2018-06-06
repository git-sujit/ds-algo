package com.sks.learn.ds;

/**
 * @author Sujit K Singh
 *
 */
public interface StackInterface_v2<T> {

	public void push(T ele);

	public T pop();

	public T peek();

	public boolean isEmpty();

	public int size();

	public void printStackContent();
}
