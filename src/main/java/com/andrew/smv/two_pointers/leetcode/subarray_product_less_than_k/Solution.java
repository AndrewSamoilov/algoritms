package com.andrew.smv.two_pointers.leetcode.subarray_product_less_than_k;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1){
            return 0;
        }

        int ans = 0;
        int product = 1;

        int l = 0;
        for (int i = 0; i < nums.length; i++) {

            product *= nums[i];

            while (product >= k && l < nums.length) {
                product /= nums[l];
                l++;
            }

            ans += i - l + 1;
        }
        return ans;
    }
}