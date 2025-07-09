package com.sks.averma2025;

import java.util.Arrays;

public class BinarySearchOnAnswerAlgos {
    private static final BinarySearchOnAnswerAlgos binarySearchOnAnswerAlgos = new BinarySearchOnAnswerAlgos();

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** BINARY SEARCH ON ANSWER ***");
        //binarySearchOnAnswerAlgos.test_peakElements();
        //binarySearchOnAnswerAlgos.test_rowColumnSortedArray();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("*** Minimum Pages to Read ***");
        binarySearchOnAnswerAlgos.test_minimumPagesToRead();
    }

    /**
     * Peak Elements: Greater than Neighbors
     */
    private int peakElements(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int s = 0, e = arr.length - 1, m = -1, prev = -1, next = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            prev = m - 1;
            next = m + 1;
            if (prev >= 0 && next < arr.length) {
                if (arr[m] > arr[prev] && arr[m] > arr[next]) return arr[m];
                else if (arr[m] > arr[prev] && arr[m] < arr[next]) s = next;
                else if (arr[m] < arr[prev] && arr[m] > arr[next]) e = prev;
                else if (arr[m] < arr[prev] && arr[m] < arr[next]) s = next;
            }
            if (m == 0 && next < arr.length && arr[m] > arr[next]) return arr[m];
            if (m == arr.length - 1 && prev >= 0 && arr[m] > arr[prev]) return arr[m];
        }
        return -1;
    }

    /**
     * Bitonic Array: Monotonically increasing then monotonically decreasing
     */
    private int maxInBitonicArray(int[] arr) {
        return peakElements(arr);
    }

    /**
     * Row & Column Sorted Array
     * (n*m) array: Each row is sorted & each column is also sorted
     * [
     * 5   10  15  20
     * 7   12  18  25
     * 9   18  24  30
     * ]
     */
    private String findEle_rowColumnSortedArray(int[][] arr, int n) {
        if (arr == null || arr.length == 0) return "(-1, -1)";
        int x = 0, y = arr[0].length - 1;
        while (x < arr.length && y >= 0) {
            if (n == arr[x][y]) return "(" + x + ", " + y + ")";
            else if (n < arr[x][y]) y--;
            else x++;
        }
        return "(-1, -1)";
    }

    /**
     * ALLOCATE MINIMUM NUMBER OF PAGES: Minimum load(Max Pages to Student)
     * Given number of pages in n different books and m students. The books are arranged in ascending order(Not Necessary) of number of pages.
     * Every student is assigned to read some consecutive books. The task is to assign books in such a way that
     * the maximum number of pages assigned to a student is minimum.
     * <p>
     * Example: Unsorted Array: Value at index-i represents pages in book-i
     * E,g: Array=[10, 15, 25, 20, 5, 40, 50]
     * Book-0 has 10 pages, Book-1 has 15 pages and so on
     * n is number of students that can read books
     * Conditions:
     * 1. One student can read multiple books but in continuous manner i.e book-0, book-1, book-2 so on
     * 2. But not in book-o, book-3, book-5 fashion
     * Minimize the load(max pages to a student) on the student
     */
    private int minimumPagesToRead(int[] books, int students) {
        if (books == null || books.length == 0 || students < 1 || students > books.length) return -1;
        int maxPages = 0, sumPages = 0;
        for (int pages : books) {
            maxPages = Math.max(maxPages, pages);
            sumPages += pages;
        }
        System.out.println("maxPages = " + maxPages + ", sumPages = " + sumPages);
        int minimumLoad = 0;
        int s = maxPages, e = sumPages, mid =   -1;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (isAllocationPossible(books, students, mid)) {
                minimumLoad = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return minimumLoad;
    }

    private boolean isAllocationPossible(int[] books, int students, int load) {
        int pageAllocated = 0;
        for (int pages : books) {
            pageAllocated += pages;
            if (pageAllocated > load) {
                students--;
                pageAllocated = pages;
            }
            if (students <= 0) return false;
        }
        return true;
    }

    /**
     * test_minimumPagesToRead
     */
    private void test_minimumPagesToRead() {
        int[] books = {10, 20, 30, 40};
        int students = 2;
        test(books, students);

        books = new int[]{12, 34, 67, 90};
        test(books, students);

        books = new int[]{1, 2, 3, 50, 100};
        test(books, students);
    }

    private static void test(int[] books, int students) {
        System.out.println("\nBooks = " + Arrays.toString(books) + ", Students = " + students);
        System.out.println("Optimum number of pages = " + binarySearchOnAnswerAlgos.minimumPagesToRead(books, students));
    }

    /**
     * TESTING...Binary Search on Answer
     */
    private void test_rowColumnSortedArray() {
        int[][] arr = {{5, 10, 15, 20}, {7, 12, 18, 25}, {9, 18, 24, 30}};
        int n = 12;
        System.out.println("2D Array => ");
        for (int[] aa : arr)
            System.out.println(Arrays.toString(aa));
        System.out.println(n + " found at : " + binarySearchOnAnswerAlgos.findEle_rowColumnSortedArray(arr, n));
        n = 4;
        System.out.println(n + " found at : " + binarySearchOnAnswerAlgos.findEle_rowColumnSortedArray(arr, n));
        n = 33;
        System.out.println(n + " found at : " + binarySearchOnAnswerAlgos.findEle_rowColumnSortedArray(arr, n));
        n = 24;
        System.out.println(n + " found at : " + binarySearchOnAnswerAlgos.findEle_rowColumnSortedArray(arr, n));
        n = 10;
        System.out.println(n + " found at : " + binarySearchOnAnswerAlgos.findEle_rowColumnSortedArray(arr, n));
        n = 18;
        System.out.println(n + " found at : " + binarySearchOnAnswerAlgos.findEle_rowColumnSortedArray(arr, n));
    }

    private void test_peakElements() {
        int[] arr = new int[]{5, 10, 20, 15};
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("Peak Element = " + binarySearchOnAnswerAlgos.peakElements(arr));

        int[] bitonic = {1, 2, 4, 5, 6, 7, 9, 10, 13, 15, 18, 7, 6, 5, 4, 3, 0};
        System.out.println("Bitonic Array = " + Arrays.toString(bitonic));
        System.out.println("Max Element = " + binarySearchOnAnswerAlgos.maxInBitonicArray(bitonic));
    }

}
