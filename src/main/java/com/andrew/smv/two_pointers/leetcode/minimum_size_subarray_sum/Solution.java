package com.andrew.smv.two_pointers.leetcode.minimum_size_subarray_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int minSubArrayLen(int target, int[] nums) { // O(n)

        int sum = 0;
        int ans = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            while (sum >= target) {
                ans = ans == 0 ? Math.max(ans, i - l + 1) : Math.min(ans, i - l + 1);
                sum -= nums[l];
                l++;
            }

        }
        return ans;
    }


    public int minSubArrayLenB(int target, int[] nums) { // O(n log(n))
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];

        for (int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        int res = 0;
        int l = 0;
        int r = prefixSums.length - 1;


        while (true) {

            int mid = (l + r) / 2;

            int prefixSum = l == 0 ? prefixSums[mid] : prefixSums[r] - prefixSums[l - 1];

            if (prefixSum >= target) {
                res = r - l + 1;
                r = mid;
            } else {
                l = mid;
            }

            if (r - l == 1) {
                break;
            }
        }

        // 2 3 1 2 4  3
        // 2 5 6 8 12 15

        if (nums[r] == target || nums[l] == target) {
            return 1;
        }

        return res;
    }

}
