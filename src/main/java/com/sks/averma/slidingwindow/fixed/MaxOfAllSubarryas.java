package com.sks.averma.slidingwindow.fixed;

import java.util.*;

public class MaxOfAllSubarryas {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for deque
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_array_DEQUEUE_BETTER(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return null;
        int[] out = new int[nums.length - k + 1];
        int ws = 0, we = 0;
        Deque<Integer> dq = new ArrayDeque<>(); //LinkedList can be also used
        while (we < nums.length) {
            int n = nums[we];
            if (dq.isEmpty()) dq.addFirst(n);
            else {
                // if n is bigger than q.first then remove all
                // If we get bigger element then clear q
                if (n >= dq.peek()) {
                    dq.clear();
                    dq.addFirst(n);
                } // Put it at its appropriate place
                else {
                    while (n > dq.peekLast())
                        dq.removeLast();
                    dq.addLast(n);
                }
            }
            if (we - ws + 1 == k) {
                out[ws] = dq.peekFirst();
                if (dq.peekFirst() == nums[ws]) {
                    dq.removeFirst();
                }
                ws++;
            }
            we++;
        }
        return out;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for deque
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_array_DEQUEUE(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return null;
        int[] out = new int[nums.length - k + 1];
        int ws = 0, we = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while (we < nums.length) {
            while (!dq.isEmpty() && dq.peek() < we - k + 1)
                dq.poll();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[we])
                dq.pollLast();
            dq.add(we);
            if (we >= k - 1) {
                out[ws++] = nums[dq.peek()];
            }
            we++;
        }
        return out;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for List
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_list_BETTER_TLE(int[] a, int k) {
        if (a == null || a.length == 0 || k > a.length) return null;
        int[] out = new int[a.length - k + 1];
        int ws = 0, we = 0;
        List<Integer> lst = new ArrayList<>();
        while (we < a.length) {
            lst.add(a[we]);
            if (we - ws + 1 == k) {
                Collections.sort(lst);
                out[ws] = lst.get(k - 1);
                lst.remove((Integer) a[ws]);
                ws++;
            }
            we++;
        }
        return out;
    }

    /**
     * Time Complexity: O(n*klogk), klogk for sorting
     * Space Complexity: O(k) for List
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_array_BETTER_TLE(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        int windowStart = 0;
        List<Integer> maxList = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            maxList.add(numbers[windowEnd]);
            Collections.sort(maxList, Comparator.reverseOrder());
            //System.out.println("maxList = " + maxList);
            if (windowEnd - windowStart + 1 == k) {
                out[windowStart] = maxList.get(0);
                //if (numbers[windowStart] == maxList.get(0)) maxList.remove(0);
                maxList.remove((Integer) numbers[windowStart]);
                windowStart++;
            }
        }
        return out;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for maxHeap
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_maxHeap_TLE(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        int windowStart = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            maxHeap.add(numbers[windowEnd]);
            if (windowEnd - windowStart + 1 == k) {
                out[windowStart] = maxHeap.peek();
                // NOTE: REMOVE A[WS] EVERYTIME
                //if (numbers[windowStart] == maxHeap.peek())
                maxHeap.remove(numbers[windowStart]);
                windowStart++;
            }
        }
        return out;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k) for List
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_array_NOT_WORKING(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        int windowStart = 0;
        LinkedList<Integer> maxList = new LinkedList<>();
        for (int windowEnd = 0; windowEnd < numbers.length; windowEnd++) {
            if (windowEnd == 0) maxList.add(numbers[windowEnd]);
            else {
                if (numbers[windowEnd] > maxList.get(0)) maxList.add(0, numbers[windowEnd]);
                else maxList.add(numbers[windowEnd]);
            }
            //System.out.println("maxList = " + maxList);
            if (windowEnd - windowStart + 1 == k) {
                out[windowStart] = maxList.get(0);
                //if (numbers[windowStart] == maxList.get(0)) maxList.remove(0);
                maxList.removeFirstOccurrence(numbers[windowStart]);
                windowStart++;
            }
        }
        return out;
    }

    /**
     * Time Complexity: O(n * k)
     * Space Complexity: O(n-k) to store the result
     * n- Length of numbers array, k is size of window
     */
    public static int[] maxOfSubArrays_bruteForce(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k <= 0 || k > numbers.length) return null;
        int[] out = new int[numbers.length - k + 1];
        for (int i = 0; i < numbers.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++)
                max = Math.max(max, numbers[j]);
            out[i] = max;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, -1, -3, 5, 3, 3, 6, 7};
        int k = 3;
        test(numbers, k);

        numbers = new int[]{1, 3, -1, -3, 5, 3, 3, 6, 7, -1, -2, -3, -4, 8};
        k = 3;
        test(numbers, k);

        numbers = new int[]{1, 3, 1, 2, 0, 5};
        k = 3;
        test(numbers, k);

        numbers = new int[]{-7, -8, 7, 5, 7, 1, 6, 0};
        k = 4;
        test(numbers, k);
    }

    private static void test(int[] numbers, int k) {
        System.out.println("\nNumbers = " + Arrays.toString(numbers) + ", Window Size K = " + k);
        System.out.println("[DEQUE_1]Max of SubArrays(Using Array) = " + Arrays.toString(maxOfSubArrays_array_DEQUEUE_BETTER(numbers, k)));
        System.out.println("[DEQUE]Max of SubArrays(Using Array) = " + Arrays.toString(maxOfSubArrays_array_DEQUEUE(numbers, k)));
        System.out.println("[Not Working]Max of SubArrays(Using Array) = " + Arrays.toString(maxOfSubArrays_array_NOT_WORKING(numbers, k)));
        System.out.println("[Better]Max of SubArrays(Using List) = " + Arrays.toString(maxOfSubArrays_list_BETTER_TLE(numbers, k)));
        System.out.println("[Better]Max of SubArrays(Using Array) = " + Arrays.toString(maxOfSubArrays_array_BETTER_TLE(numbers, k)));
        System.out.println("Max of SubArrays(Using Heap)  = " + Arrays.toString(maxOfSubArrays_maxHeap_TLE(numbers, k)));
        System.out.println("[Brute Force] Max of SubArrays= " + Arrays.toString(maxOfSubArrays_bruteForce(numbers, k)));
    }
}
