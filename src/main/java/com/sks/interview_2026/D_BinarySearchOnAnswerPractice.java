package com.sks.interview_2026;

import java.util.Arrays;

public class D_BinarySearchOnAnswerPractice {
    public static void main(String[] args) {
        System.out.println("----- PEAK ELEMENT -----");
        test_peakElement();

        System.out.println("----- BITONIC ARRAY -----");
        test_bitonicArray();

        System.out.println("----- ROW & COLUMN SORTED ARRAY -----");
        test_rowColumnSortedArray();

        System.out.println("----- ROW & COLUMN SORTED ARRAY -----");
        test_rowColumnSortedArray();

        System.out.println("----- ALLOCATE MIN-PAGES TO STUDENTS -----");
        test_allocateMinPagesToStudents();
    }


    /**
     * Time Complexity:  O(logn), Space Complexity: O(1)
     */
    public static int findPeakElement(int[] a) {
        if (a == null || a.length == 0) return -1;
        int s = 0, e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid > 0 && mid < a.length - 1) {
                if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return a[mid];
                else if (a[mid] < a[mid - 1]) e = mid - 1;
                else if (a[mid] < a[mid + 1]) s = mid + 1;
            } else if (mid == 0) {
                if (mid + 1 < a.length && a[mid] > a[mid + 1]) return a[mid];
                else s = mid + 1;
            } else if (mid == a.length - 1) {
                if (mid - 1 >= 0 && a[mid] > a[mid - 1]) return a[mid];
                else e = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Time Complexity:  O(logn), Space Complexity: O(logn)
     */
    private static int maxElement(int[] bitonic) {
        if (bitonic == null || bitonic.length == 0) return -1;
        if (bitonic.length == 1) return bitonic[0];
        return findPeakElement(bitonic);
    }

    private static int searchInBitonicArray(int[] bitonic, int n) {
        int maxElement = maxElement(bitonic);
        if (n == maxElement) return maxElement;
        int leftSearch = binarySearch_orderAgnostic(bitonic, n, 0, maxElement - 1);
        if (leftSearch != -1) return leftSearch;
        else return binarySearch_orderAgnostic(bitonic, n, maxElement - 1, bitonic.length - 1);
    }

    private static int binarySearch_orderAgnostic(int[] nums, int n, int s, int e) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == n ? 0 : -1;
        boolean ascFlag = (nums[0] <= nums[1]);
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (n == nums[m]) return m;
            else if (n < nums[m]) {
                if (ascFlag) e = m - 1;
                else s = m + 1;
            } else {
                if (ascFlag) s = m + 1;
                else e = m - 1;
            }
        }
        return -1;
    }

    /**
     * Time Complexity: O(rows+cols) ~ O(n), each iteration we are removing one row or column
     * Space Complexity: O(1)
     */
    private static int[] search_rowColumnSortedArray(int[][] nums, int n) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) return new int[]{-1, -1};
        int i = 0, j = nums[0].length - 1;
        while (i < nums.length && j >= 0) {
            if (n == nums[i][j]) return new int[]{i, j};
            else if (n > nums[i][j]) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }

    /**
     * Time Complexity: O(nmlogn), n is array size, m is no. of students
     */
    private static int allocateMinPagesToRead(int[] books, int students) {
        if (books == null || books.length == 0) return -1;
        if (students > books.length) return -1;
        // Start=Max of array & end=sum of array
        int start = 0, end = Arrays.stream(books).sum(), result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid_better(books, students, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid_better(int[] books, int students, int max) {
        int sum = 0;
        for (int pages : books) {
            sum += pages;
            if (sum > max) {
                sum = pages;
                students--;
            }
            if (students <= 0) return false;
        }
        return true;
    }

    /**
     * TEST
     */
    private static void test_peakElement() {
        int[] a = {5, 10, 20, 15};
        System.out.println("\nArray = " + Arrays.toString(a));
        System.out.println("Peak Element = " + findPeakElement(a));

        a = new int[]{12, 30, 20, 40, 18};
        System.out.println("\nArray = " + Arrays.toString(a));
        System.out.println("Peak Element = " + findPeakElement(a));

        a = new int[]{25, 10, 8, 15, 6};
        System.out.println("\nArray = " + Arrays.toString(a));
        System.out.println("Peak Element = " + findPeakElement(a));

        a = new int[]{25};
        System.out.println("\nArray = " + Arrays.toString(a));
        System.out.println("Peak Element = " + findPeakElement(a));
    }

    private static void test_bitonicArray() {
        int[] bitonic = {1, 2, 4, 5, 6, 7, 9, 10, 13, 15, 18, 7, 6, 5, 4, 3, 0};
        int[] search = {10, 3, 0, 1, 4, 13};
        System.out.println("\nBitonic array = " + Arrays.toString(bitonic));
        System.out.println("Max element =" + maxElement(bitonic));
        for (int s : search)
            System.out.println("Element " + s + " at Index\t: " + searchInBitonicArray(bitonic, s));
    }

    private static void test_rowColumnSortedArray() {
        int[][] nums = {{5, 10, 15, 20}, {7, 12, 18, 25}, {9, 18, 24, 30}};
        int n = 12;
        System.out.println("2D Array => ");
        for (int[] aa : nums)
            System.out.println(Arrays.toString(aa));

        System.out.println(n + " found at : " + Arrays.toString(search_rowColumnSortedArray(nums, n)));

        n = 4;
        System.out.println(n + " found at : " + Arrays.toString(search_rowColumnSortedArray(nums, n)));
    }

    private static void test_allocateMinPagesToStudents() {
        int[] books = {10, 20, 30, 40};
        int students = 2;
        test(books, students);

        books = new int[]{12, 34, 67, 90};
        test(books, students);

        books = new int[]{1, 2, 3, 50, 100};
        test(books, students);
    }

    private static void test(int[] books, int students) {
        System.out.println("Books = " + Arrays.toString(books) + ", Students = " + students);
        System.out.println("Optimum number of pages = " + allocateMinPagesToRead(books, students));
    }
}
