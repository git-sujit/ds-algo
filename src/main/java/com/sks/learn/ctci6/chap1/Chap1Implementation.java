package com.sks.learn.ctci6.chap1;

import java.util.HashSet;
import java.util.Set;

public class Chap1Implementation implements Chap1Contract {

	/**
	 * Time Complexity = O(length of String): Linear
	 * 
	 * Space Complexity = O(length of String), Extra Set
	 */
	@Override
	public boolean isUniqueExtraSpace(String s) {
		Set<Character> existingCharSet = new HashSet<Character>();
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			if (existingCharSet.contains(c)) {
				return false;
			}
			existingCharSet.add(c);
		}
		System.out.println("existingCharSet=" + existingCharSet);
		return true;
	}

	/**
	 * Time Complexity = O(n^2): Quadratic
	 * 
	 * Space Complexity = O(1) [In-Memory]
	 */
	@Override
	public boolean isUniqueInMemory(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Time Complexity = O(length of String): Linear
	 * 
	 * Space Complexity = O(length of String), Extra Char[]
	 */
	@Override
	public boolean isUniqueCtci(String s) {
		int sLen = s.length();
		// Assumption: Character set is ASCI only
		// Char is 16 bit: First 128 Unicode Code points are ASCII
		// Extended ASCII: 256
		if (sLen > 128) {
			return false;
		}
		boolean[] bArr = new boolean[128];
		for (int i = 0; i < sLen; i++) {
			char currC = s.charAt(i);
			if (bArr[currC]) {
				return false;
			}
			bArr[currC] = true;
		}
		return true;
	}

	/**
	 * Time Complexity = O(s1Len*s2Len): Quadratic
	 * 
	 * Space Complexity = O(1), In Memory
	 */
	@Override
	public boolean isPermutationInMemory(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		if (s1Len != s2Len) {
			return false;
		}
		for (int i = 0; i < s1Len; i++) {
			char c1 = s1.charAt(i);
			boolean found = false;
			for (int j = 0; j < s2Len; j++) {
				char c2 = s2.charAt(j);
				if (c1 == c2) {
					found = true;
				}
			}
			if (!found) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String compressString(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int i = 0;
		while (i < len) {
			System.out.println(" i = " + i);
			char c = s.charAt(i);
			int count = 1;
			// TO STOP INFINITE LOOP
			if (i == (len - 1)) {
				break;
			}
			for (int j = i + 1; j < len; j++) {
				i = j;
				char c1 = s.charAt(j);
				if (c == c1) {
					count++;
				} else {
					break;
				}
			}
			sb.append("" + c + count);
		}
		return sb.toString();
	}

	public String compressString1(String s) {
		if (s == null)
			return null;
		int len = s.length();
		if (len == 0)
			return null;

		StringBuilder cmp = new StringBuilder();
		char prev = s.charAt(0);
		int count = 1;
		for (int i = 1; i < len; i++) {
			char c = s.charAt(i);
			if (c == prev) {
				count++;
			} else {
				cmp.append("" + prev + count);
				prev = c;
				count = 1;
			}
		}
		if (s.charAt(len - 2) == prev) {
			cmp.append("" + prev + count);
		} else {
			cmp.append("" + prev + count);
		}

		if (cmp.toString().length() >= len) {
			return s;
		} else {
			return cmp.toString();
		}

	}

	@Override
	public void zeroMatrix(int[][] matrix) {
		// Boundary condition
		if (matrix == null)
			return;
		int m = matrix.length;
		int n = 0;
		Set<Integer> zeroRowSet = new HashSet<Integer>();
		Set<Integer> zeroColSet = new HashSet<Integer>();

		// Mark
		for (int i = 0; i < m; i++) {
			if (i == 0 && matrix[0] != null) {
				n = matrix[0].length;
				if (n == 0) {
					return;
				}
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					zeroRowSet.add(i);
					zeroColSet.add(j);
				}
			}
		}
		// Set Row Zero
		for (int j = 0; j < n; j++) {
			for (int rowNum : zeroRowSet) {
				matrix[rowNum][j] = 0;
			}
		}
		// Set Column Zero
		for (int i = 0; i < m; i++) {
			for (int colNum : zeroColSet) {
				matrix[i][colNum] = 0;
			}

		}
	}

	@Override
	public void zeroMatrixMemoryEfficient(int[][] matrix) {
		// Boundary condition check
		if (matrix == null)
			return;
		int m = matrix.length;
		int n = 0;
		if (matrix[0] != null)
			n = matrix[0].length;
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;

		// Check if first row has zero
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				firstRowHasZero = true;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}
		// Set first row/column zero
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Make row zero
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}

		}

		// Make column zero
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		// Make first row/colum zero if applies
		if (firstRowHasZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		if (firstColHasZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	// Time Complexity: O(n^2)
	// Space Complexity: O(n^2)
	@Override
	public void rotateMatrix(int[][] matrix) {
		if (matrix == null)
			return;
		int n = matrix.length;
		if (n == 0 || matrix[0].length != n)
			return;
		// Copy to temp matrix
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = matrix[i][j];
			}
		}

		// Rotate 90 degree
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = temp[j][n - 1 - i];
			}
		}
	}

	// Time Complexity: O(n^2)
	// Space Complexity: O(1) :: In-Place rotation
	public void rotateMatrix_SpaceEfficient(int[][] matrix) {

	}

	/**
	 * Copy array<br>
	 * Clone Vs System.arraycopy() :: arraycopy is better<br>
	 * arraycopy is efficient as it runs native code(In C) <br>
	 * arraycopy gives more flexibility to partially copy array
	 * 
	 * @param a
	 * @return
	 */
	private int[] copyArray_clone(int[] a) {
		int[] copy = a.clone();
		return copy;
	}

	private int[] copyArray_system(int[] a) {
		int[] copy = new int[a.length];
		System.arraycopy(a, 0, copy, 0, a.length);
		return copy;
	}

	public static void main(String[] args) {
		Chap1Implementation obj = new Chap1Implementation();

		String str = "aabcccccaaadtttttyyy";
		System.out.println("Original = " + str + ", Compressed = " + obj.compressString1(str));

		int[][] matrix = { { 1, 2, 3, 0 }, { 0, 3, 2, 4 }, { 1, 7, 9, 3 } };
		obj.printMatrix(matrix);
		obj.zeroMatrix(matrix);
		System.out.println("**** ZERO MATRIX *** \n");
		obj.printMatrix(matrix);

		System.out.println("**** \n EFFICIENT ALGO *** \n");
		int[][] matrix1 = { { 1, 2, 3, 0 }, { 0, 3, 2, 4 }, { 1, 7, 9, 3 } };
		obj.printMatrix(matrix1);
		obj.zeroMatrix(matrix1);
		System.out.println("**** ZERO MATRIX : EFFICIENT*** \n");
		obj.printMatrix(matrix1);

		System.out.println("**** \n ROTATE MATRIX *** \n");
		int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		obj.printMatrix(matrix2);
		obj.rotateMatrix(matrix2);
		System.out.println("**** AFTER 90 DEGREE ROTATION *** \n");
		obj.printMatrix(matrix2);
	}

	public void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
