 package com.andrew.smv.two_pointers.codeforces.non_secret_cypher;


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

            String line = br.readLine();

            int books = Integer.parseInt(line.split(" ")[0]);
            int k = Integer.parseInt(line.split(" ")[1]);


            String[] secondLine = br.readLine().split(" ");

            int[] array = new int[books];

            for (int i = 0; i < books; i++) {
                array[i] = Integer.parseInt(secondLine[i]);
            }

            long count = solution.countArrays(array, k);

            System.out.println(count);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Solution {


        public long countArrays(int[] nums, int countOfTheSameNumbers) {

            Map<Integer, Integer> map = new HashMap<>();

            long totalGood = 0;
            int l = 0;

            for (int i = 0; i < nums.length; i++) {

                int rightPointerValue = nums[i];
                Integer value = map.get(rightPointerValue);
                if (value == null) {
                    map.put(rightPointerValue, 1);
                } else {
                    map.computeIfPresent(rightPointerValue, (k, v) -> ++v);
                }

                while (map.getOrDefault(rightPointerValue, 0) == countOfTheSameNumbers) {
                    totalGood += nums.length - i;
                    map.computeIfPresent(nums[l], (k, v) -> --v);
                    l++;
                }
            }

            return totalGood;
        }
    }
}
