package com.sks.averma.binarysearch;

import java.util.Arrays;

/**
 * ALLOCATE MINIMUM NUMBER OF PAGES
 * Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages.
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
 * Minimize the load on te student
 */
public class PagesOfBooks {

    /**
     * Time Complexity: O(nmlogn)
     * n is array size, m is no. of students
     */
    public static int minimumPagesToRead(int[] books, int students) {
        if (books == null || books.length == 0) return -1;
        if (students > books.length) return -1;
        // Start=Max of array & end=sum of array
        int start = 0;
        int end = 0;
        int result = -1;
        for (int pages : books) {
            end += pages;
            start = Math.max(start, pages);
        }
        //System.out.println("Start = " + start + ", End = " + end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid_better(books, students, mid)) {
            //if (isValid(books, students, mid)) {
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

    private static boolean isValid(int[] books, int students, int max) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i];
            if (sum > max) {
                student++;
                sum = books[i];
            }
            if (student > students)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] books = {10, 20, 30, 40};
        int students = 2;
        test(books, students);

        books = new int[]{12, 34, 67, 90};
        students = 2;
        test(books, students);

        books = new int[]{1, 2, 3, 50, 100};
        students = 2;
        test(books, students);
    }

    private static void test(int[] books, int students) {
        System.out.println("\nBooks = " + Arrays.toString(books) + ", Students = " + students);
        System.out.println("Optimum number of pages = " + minimumPagesToRead(books, students));
    }
}
