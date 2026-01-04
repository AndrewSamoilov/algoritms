package com.andrew.smv.two_pointers.codeforces.books;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

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

            int count = solution.countBooksWithWhile(timePerBookArray, freeTime);

            System.out.println(count);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Solution {


        public int countBooks(int[] requiredTimes, int freeTime) {

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


        public int countBooksWithWhile(int[] requiredTimes, int freeTime) {

            int leftPointer = 0;
            int res = 0;
            int sum = 0;
            for (int i = 0; i < requiredTimes.length; i++) {

                sum += requiredTimes[i];

                while (sum > freeTime) {
                    sum -= requiredTimes[leftPointer];
                    leftPointer++;
                }

                int a = i - leftPointer + 1;
                res = max(a, res);
            }
            return res;
        }


    }
}





