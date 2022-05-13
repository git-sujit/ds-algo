package com.sks.interview_2022;

/**
 * Roblox collects lots of time-series data.  Here is some represented by an array of integers, where the index indicates the time point (eg: minute 0 => value is 8):
 * <p>
 * [ 8, 9, 10, 11, 12, 10, 9, 8, 7, 8, 6 ]
 * <p>
 * Question 1:
 * Please write a method or function that takes in time series data like above and returns all local peaks.  A local peak is defined as any time the line is trending upwards, and begins trending downwards.  In the above example index 4 (value 12) is a peak and index 9 (value 8) is a peak.
 * <p>
 * consider a line that begins descending or line that ends ascending as having peaks at the edge.
 * [9, 8] => 9
 * [9, 10]
 * <p>
 * Question 2:
 * There is a case where the data comes up to a plateau, meaning a peak value across consecutive data points (eg 1,2,3,4,4,4,3,2,1).  Plateaus should be handled by returning one value or index to represent the peak in the plateau (eg 4 from above example).  If returning the index, any index along the plateau is valid (leading edge, trailing edge, somewhere in the middle).
 * <p>
 * [9, 9, 8] -> (0, 9)
 * <p>
 * System Design:
 * Liked Items
 * Roblox has a marketplace with millions of items for sale.For each item,users can choose to flag it as a Liked.An item which is flagged can be un-flagged.
 * Design a system which is able to show the number of likes each item has.
 * <p>
 * User Stories:
 * -As a user,I want to know if this item is flagged as a liked item for me(1M qps)
 * -As a user,I want to flag/unflag this item as a liked/unliked(100k qps)
 * -As a user,I want to see the count of all users who had liked this(1M qps)
 * <p>
 * <p>
 * Item,User,Like(user,item_id),Like_count(Item,count)
 * <p>
 * System Design:
 * Liked Items
 * Roblox has a marketplace with millions of items for sale.For each item,users can choose to flag it as a Liked.An item which is flagged can be un-flagged.
 * Design a system which is able to show the number of likes each item has.
 * <p>
 * User Stories:
 * -As a user,I want to know if this item is flagged as a liked item for me(1M qps)
 * -As a user,I want to flag/unflag this item as a liked/unliked(100k qps)
 * -As a user,I want to see the count of all users who had liked this(1M qps)
 * <p>
 * <p>
 * Item,User,Like(user,item_id),Like_count(Item,count)
 **/
/**
 System Design:
 Liked Items
 Roblox has a marketplace with millions of items for sale.For each item,users can choose to flag it as a Liked.An item which is flagged can be un-flagged.
 Design a system which is able to show the number of likes each item has.

 User Stories:
 -As a user,I want to know if this item is flagged as a liked item for me(1M qps)
 -As a user,I want to flag/unflag this item as a liked/unliked(100k qps)
 -As a user,I want to see the count of all users who had liked this(1M qps)


 Item,User,Like(user,item_id),Like_count(Item,count)
 **/

import java.util.ArrayList;
import java.util.List;

// Main class should be named 'Solution'
class RobloxOnsite {
    public static void main(String[] args) {
        int[] nums = {8, 9, 10, 11, 12, 10, 9, 8, 7, 8, 6};
        demo(nums);
        demo(new int[]{8});
        demo(new int[]{9, 8});
        demo(new int[]{9, 10});
        int[] nums1 = {1, 2, 3, 4, 4, 4, 3, 2, 1};
        System.out.println("Local Peaks with Plataeu = " + new RobloxOnsite().localPeaks_withPlataeu(nums1));
    }

    private static void demo(int[] nums) {
        System.out.println("Local Peaks = " + new RobloxOnsite().localPeaks(nums));
    }

    //1,2,3,4,4,4,3,2,1
    public List<CustomPair> localPeaks_withPlataeu(int[] nums) {
        List<CustomPair> out = new ArrayList<>();
        if (nums == null || nums.length == 0) return out;
        int len = nums.length;
        int tp = 0;
        while (tp < len) {
            if (tp == 0) {
                while (tp + 1 < len && nums[tp] == nums[tp + 1]) tp++;
                if (tp < len - 1 && nums[tp] > nums[tp + 1]) out.add(new CustomPair(tp, nums[tp]));
            } else if (tp == len - 1 && tp - 1 >= 0 && nums[tp] > nums[tp - 1]) {
                out.add(new CustomPair(tp, nums[tp]));
            } else {
                int oPrev = tp - 1;
                while (tp + 1 < len && nums[tp] == nums[tp + 1]) tp++;
                int prev = tp - 1;
                int next = tp + 1;
                if (prev >= 0 && next < len && nums[tp] > nums[oPrev] && nums[tp] > nums[next])
                    out.add(new CustomPair(tp, nums[tp]));
            }
            tp++;
        }
        return out;
    }

    public List<CustomPair> localPeaks(int[] nums) {
        List<CustomPair> out = new ArrayList<>();
        if (nums == null || nums.length == 0) return out;
        int len = nums.length;
        for (int tp = 0; tp < len; tp++) {
            if (tp == 0 && tp + 1 < len && nums[tp] > nums[tp + 1]) out.add(new CustomPair(tp, nums[tp]));
            else if (tp == len - 1 && tp - 1 >= 0 && nums[tp] > nums[tp - 1]) out.add(new CustomPair(tp, nums[tp]));
            else {
                int prev = tp - 1;
                int next = tp + 1;
                if (prev >= 0 && next < len && nums[tp] > nums[prev] && nums[tp] > nums[next])
                    out.add(new CustomPair(tp, nums[tp]));
            }
        }
        return out;
    }

    class CustomPair {
        private int key;
        private int value;

        public CustomPair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getvalue() {
            return this.value;
        }

        @Override
        public String toString() {
            return "(key=" + key + ", value=" + value + ")";
        }
    }
}



