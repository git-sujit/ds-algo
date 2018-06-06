package com.sks.learn.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Asymptotic Analysis: Time : O(1) Space: Array so lesser space than LinkedList
 * Enhancements: Resizing the Array: Repeated Doubling during Push operation The
 * idea is to reduce the frequency of copying the data to new array : O(n) Note:
 * If you increase size by 1 each time then it will be O(n^2) For pop - shrink
 * array : Thrashing - push-pop-push-pop when array is full then it will
 * double-half-double-half
 * 
 * Resize Array: Push - double size of array s[] when array is full Pop - half
 * size of array s[] when array is one-quarter full Why not half the array when
 * array is half full : Thrashing
 * 
 * Use Array with N=10 Capacity Note - nextAvailableIndex points to null entry
 * Fundamental Defect in using Array : We have to declare size of Array If size
 * increases then we have to increase the Capacity For fixed capacity Stack
 * implementation is best But providing client capacity is not good so we need
 * array resizing
 * 
 * Resizing Array Vs Linked List Linked List : Every operation is O(1) in worst
 * case but we need more space to build links Resizing Array: Better Amortized
 * time: Lesser wasted space
 * 
 * @author Sujit K Singh
 *
 */
public class StackArrayImpl_v2 implements StackInterface_v2<Integer> {

	List<Integer> col = new ArrayList<Integer>();

	@Override
	public void push(Integer ele) {
		col.add(ele);
	}

	@Override
	public Integer pop() {
		return col.remove(size() - 1);
	}

	@Override
	public Integer peek() {
		return col.get(size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return col.isEmpty();
	}

	@Override
	public int size() {
		return col.size();
	}

	@Override
	public void printStackContent() {

	}

}
