package com.sks.interview_2026.companies;

import java.util.*;

/**
 * """
 * A union B :
 * A \intersect B (\cap) :
 * --
 * to make this a bit shorter - consider duplicates (so more lists not sets)
 * --
 * Parameters
 * a list of non-null integers, in ascending order
 * b list of non-null integers, in ascending order
 *
 * param  a list of non-null integers, in ascending order
 * param b a list of non-null integers, in ascending order
 * @return the integers that are contained in either a or b, in ascending order
 * union([1,2,3], [3,4,5]) == [1,2,3,4,5]
 * """
 * def union(a:List[int], b:List[int]) -> List[int]:
 * """
 * @return the integers that are contained in both a and b, in ascending order
 * intersect([1,2,3,4], [3,4,5]) == [3,4]
 * """
 * //def intersect(a:List[int], b:List[int]) -> List[int]:
 **/

public class LinkedInInterview {


    public List<Integer> union(int[] nums1, int[] nums2) {

        if (nums1 == null && nums2 == null) return null;
        List<Integer> out = new ArrayList<>();
        //if (nums1 == null || nums2 == null) return (nums1 == null) ? (List<Integer>)Arrays.asList(nums2) :  (List<Integer>)Arrays.asList(nums1);
        /**
         * [1,2,3,4]
         * [3,4,4,4,5,5,5,5]
         * i = 0, 1, 2, 3, 4
         * j = 0, 1, 2
         * out = [1, 2, 3, 4, 5]
         */
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                out.add(nums1[i]);
                i++;
            } else if (nums1[i] == nums2[j]) {
                out.add(nums1[i]);
                int num = nums1[i];
                i++;
                j++;
                while (i < nums1.length && num == nums1[i]) i++;
                while (j < nums2.length && num == nums2[j]) j++;
            } else {
                out.add(nums2[j]);
                j++;
            }
        }
        int prev = nums1[i - 1];
        if (i < nums1.length) {
            while (i < nums1.length && prev != nums1[i]) {
                prev = nums1[i];
                out.add(nums1[i++]);
            }
        }
        prev = nums2[j - 1];
        if (j < nums2.length) {
            while (j < nums2.length && prev != nums2[j]) {
                prev = nums2[j];
                out.add(nums2[j++]);
            }
        }
        return out;

    }

    public List<Integer> intersection(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0)) return null;
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) return null;

        List<Integer> out = new ArrayList<>();
        int i = 0, j = 0;
        /**
         * [1,2,3,4]
         * [3,4,4,4,5,5,5,5]
         * i = 0, 1, 2, 3
         * j = 0, 1
         * out = [3, ]
         */
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                out.add(nums1[i]);
                int num = nums1[i];
                i++;
                j++;
                while (i < nums1.length && num == nums1[i]) i++;
                while (j < nums2.length && num == nums2[j]) j++;
            } else j++;
        }
        return out;
    }
}

