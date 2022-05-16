package com.sks.XDEPRECATED.algo2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};
        int target = 0;
        List<int[]> result = find_triplet(arr, target);

        for (int[] res : result) {
            System.out.println(res);
        }
    }

    private static List find_triplet(int[] arr, int k) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            two_sum(arr, i, result, k - arr[i]);
        }

        return result;
    }


    private static void two_sum(int[] arr, int i, List result, int target) {
        int low = 0;
        int high = arr.length - 1;
        int s = 0;
        while (low < high) {
            s = arr[i] + arr[low] + arr[high];
            if (s < target)
                low++;
            else if (s > target)
                high--;
            else {
                //result.append([arr[i], arr[low], arr[high]])
                int[] res = {arr[i], arr[low], arr[high]};
                result.add(res);
                low++;
                high--;
            }
        }
    }
}
