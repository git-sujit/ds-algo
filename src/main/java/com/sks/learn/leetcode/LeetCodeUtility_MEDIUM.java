package com.sks.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeUtility_MEDIUM {

	public static void main(String[] args) {
		int[] num = { -1, 0, 1, 2, -1, -4 };
		// System.out.println("threeSum = " + threeSum(num));
		System.out.println("threeSum_1 = " + threeSum_1(num));
		int dividend = 7;
		int divisor = 3;
		System.out.println(
				"dividend = " + dividend + ", divisor = " + divisor + ": Quotient = " + divide(dividend, divisor));
	}

	public static int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		int quotient = 0;
		while (dividend > 0) {
			dividend -= divisor;
			if (dividend >= 0) {
				quotient++;
			}
		}
		return quotient;
	}

	public static List<List<Integer>> threeSum_1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int lo = i + 1;
			int hi = len - 1;
			int comp = -nums[i];
			while (lo < hi) {
				if (nums[lo] + nums[hi] == comp) {
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					break;
				} else if (nums[lo] + nums[hi] < comp) {
					lo++;
				} else {
					hi--;
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
}
