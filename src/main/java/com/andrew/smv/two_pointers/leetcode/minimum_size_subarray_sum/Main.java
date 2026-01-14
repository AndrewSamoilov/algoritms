package com.andrew.smv.two_pointers.leetcode.minimum_size_subarray_sum;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.minSubArrayLen(7, new int[]{1,2,4,3}));
        System.out.println(solution.minSubArrayLenB(7, new int[]{1,2,4,3}));

    }
}
