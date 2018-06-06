/**
 * 
 */
package com.sks.learn.ctci6.chap1;

/**
 * @author Sujit
 *
 */
public interface Chap1Contract {

	public abstract boolean isUniqueExtraSpace(String s);

	public abstract boolean isUniqueInMemory(String s);

	public abstract boolean isUniqueCtci(String s);

	public abstract boolean isPermutationInMemory(String s1, String s2);

	public abstract String compressString(String s);

	public abstract void zeroMatrix(int[][] matrix);

	public abstract void zeroMatrixMemoryEfficient(int[][] matrix);

	public abstract void rotateMatrix(int[][] matrix);
}
