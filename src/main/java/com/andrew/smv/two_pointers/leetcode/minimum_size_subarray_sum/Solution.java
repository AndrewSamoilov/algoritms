package com.andrew.smv.two_pointers.leetcode.minimum_size_subarray_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int minSubArrayLen(int target, int[] nums) {

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

}
