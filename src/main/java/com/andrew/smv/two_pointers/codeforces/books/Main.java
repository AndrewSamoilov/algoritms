package com.andrew.smv.two_pointers.codeforces.books;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();


        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();

            int books = Integer.parseInt(line.split(" ")[0]);
            int freeTime = Integer.parseInt(line.split(" ")[1]);


            String[] secondLine = br.readLine().split(" ");

            int[] timePerBookArray = new int[books];

            for (int i = 0; i < books; i++) {
                timePerBookArray[i] = Integer.parseInt(secondLine[i]);
            }

            int count = solution.contBooks(timePerBookArray, freeTime);

            System.out.println(count);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Solution {


        public int contBooks(int[] requiredTimes, int freeTime) {

            int leftPointer = 0;
            int sum = 0;
            int i;
            for (i = 0; i < requiredTimes.length; i++) {

                sum += requiredTimes[i];

                if (sum > freeTime) {
                    sum -= requiredTimes[leftPointer];
                    leftPointer++;
                }
            }
            return i - leftPointer;
        }


    }
}





