package com.andrew.smv.two_pointers.leetcode.count_number_of_nice_subarrays;

class Solution {

    public int numberOfSubarrays(int[] nums, int k) {

        int[] arr = new int[2];

        int res = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {
                arr[0]++;
            } else {
                arr[1]++;
            }

            while (arr[1] == k) {
                if (nums[l] % 2 == 0) {
                    arr[0]--;
                } else {
                    arr[1]--;
                }
                res += nums.length - i;
                l++;
            }


        }

        return res;
    }


    private int solve(String s, int k) {
        if (s.length() - k < 1) {
            return 0;
        }


        return 1;
    }


    public int longestSubstring(String s, int k) {
        int[] seen = new int[26];
        int l = 0;
        int res = 0;


        for (int i = 0; i < s.length(); i++) {
            int index = 'c' - s.charAt(i);
            seen[index]++;
        }

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            int index = 'c' - c;

            if (seen[index] < k) {
                String substring = s.substring(0, c);
                String a = s.substring(c + 1, s.length() + 1);
            }


        }


        return res;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }


    public long getDescentPeriods(int[] prices) {

        if (prices.length == 1) {
            return 1L;
        }

        int l = 0;
        long res = 0;

        int prev = prices[0];

        for (int i = 0; i < prices.length; i++) {

            int current = prices[i];

//            while (i != 0 && prev - current != 1 && i > l) {
//                prev = prices[l];
//                l++;
//            }

            if (i != 0 && prev - current != 1 && i > l) {
                l = i;
                prev = prices[i];
            }

            prev = current;
            res += i - l + 1;
        }
        return res;
    }

}