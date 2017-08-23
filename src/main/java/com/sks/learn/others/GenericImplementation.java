package com.sks.learn.others;

/**
 * @author Sujit
 *
 * @param <E>
 *            : Element
 * @param <T>
 *            : Type
 */
public class GenericImplementation<E, T> implements GenericInterface<E, T> {
	public static void main(String[] args) {
		GenericInterface<String, Integer> obj1 = new GenericImplementation<String, Integer>();
		obj1.printIt("SUJIT", 4);

		GenericInterface<Float, Boolean> obj2 = new GenericImplementation<Float, Boolean>();
		obj2.printIt(0.45f, true);

	}

	@Override
	public void printIt(E e, T t) {
		System.out.println("E = " + e + ", Class of E = " + e.getClass());
		System.out.println("T = " + t + ", Class of T = " + t.getClass());
	}
}
