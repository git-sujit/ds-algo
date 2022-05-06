package com.sks.leetcode.hard;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) return 0;
        int l1, l2;
        if (nums1 == null) {
            l2 = nums2.length;
            if (l2 % 2 == 0) return ((double) nums2[l2 / 2 - 1] + nums2[l2 / 2]) / 2;
            else return nums2[l2 / 2];
        }
        if (nums2 == null) {
            l1 = nums1.length;
            if (l1 % 2 == 0) return (nums1[l1 / 2 - 1] + nums1[l1 / 2]) / 2;
            else return nums1[l1 / 2];
        }
        l1 = nums1.length;
        l2 = nums2.length;
        int l = l1 + l2;
        int[] sortedNums = new int[l];
        mergeSortedArrays(nums1, nums2, sortedNums);
        System.out.println("Merged Sorted Array = " + Arrays.toString(sortedNums));
        if (l % 2 == 0) return ((double) sortedNums[l / 2 - 1] + sortedNums[l / 2]) / 2;
        else return sortedNums[l / 2];
    }

    private static void mergeSortedArrays(int[] nums1, int[] nums2, int[] sortedNums) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = sortedNums.length;
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < l1 && i2 < l2 && i < l) {
            if (nums1[i1] < nums2[i2]) sortedNums[i++] = nums1[i1++];
            else sortedNums[i++] = nums2[i2++];
        }
        while (i1 < l1 && i < l) sortedNums[i++] = nums1[i1++];
        while (i2 < l2 && i < l) sortedNums[i++] = nums2[i2++];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Sorted Array - 1 = " + Arrays.toString(nums1));
        System.out.println("Sorted Array - 2 = " + Arrays.toString(nums2));
        System.out.println("MEDIAN = " + findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println("\nSorted Array - 1 = " + Arrays.toString(nums1));
        System.out.println("Sorted Array - 2 = " + Arrays.toString(nums2));
        System.out.println("MEDIAN = " + findMedianSortedArrays(nums1, nums2));


        nums1 = new int[]{1, 4, 7, 9};
        nums2 = new int[]{2, 4, 8, 8, 20, 22, 25, 28};
        System.out.println("\nSorted Array - 1 = " + Arrays.toString(nums1));
        System.out.println("Sorted Array - 2 = " + Arrays.toString(nums2));
        System.out.println("MEDIAN = " + findMedianSortedArrays(nums1, nums2));
    }
}
