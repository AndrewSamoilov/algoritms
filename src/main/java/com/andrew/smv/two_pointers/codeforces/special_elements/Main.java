package com.andrew.smv.two_pointers.codeforces.special_elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();


        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int dataCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < dataCount; i++) {
                int arraySize = Integer.parseInt(br.readLine());

                int[] shorts = new int[arraySize];

                String[] nums = br.readLine().split(" ");
                for (int j = 0; j < arraySize; j++) {
                    shorts[j] = Short.parseShort(nums[j]);
                }

                System.out.println(solution.countSpecialNumbers(shorts));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Solution {


        public int countSpecialNumbers(int[] nums) {

            int[] prefixSum = new int[nums.length];

            prefixSum[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }

            int res = 0;

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] > prefixSum[i]) {
                    continue;
                }
                int number = nums[i];

                // sum(l, r) = p(r) - p(l-1)

                res += count(nums, prefixSum, i, number);

            }

            return res;
        }


        private int count(int[] nums, int[] prefixSums, int r, int target) {

            // sum(l, r) = p(r) - p(l-1)

            int s = 0;
            int l = 0;
            for (int i = 0; i < r; i++) {
                int prefixS = l == 0 ? prefixSums[i] : prefixSums[r] - prefixSums[l - 1];

                while (prefixS == target) {
                    s++;
                    l++;
                    prefixS = prefixSums[r] - prefixSums[l - 1];
                }

            }


            return s;
        }


    }
}
