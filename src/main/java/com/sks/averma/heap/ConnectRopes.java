package com.sks.averma.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to the sum of their lengths. We need to connect the ropes with minimum cost.
 */
public class ConnectRopes {
    /**
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n) for priority queue
     */
    public static int minCostOfConnectingRopes(int[] ropes) {
        if (ropes == null || ropes.length <= 1) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) minHeap.add(rope);
        int totalCost = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.remove() + minHeap.remove();
            minHeap.add(cost);
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {1, 2, 3, 4, 5};
        System.out.println("\nRopes = " + Arrays.toString(ropes));
        System.out.println("Minimum Cost = " + minCostOfConnectingRopes(ropes));
        ropes = new int[]{4, 3, 2, 6};
        System.out.println("\nRopes = " + Arrays.toString(ropes));
        System.out.println("Minimum Cost = " + minCostOfConnectingRopes(ropes));
    }
}
