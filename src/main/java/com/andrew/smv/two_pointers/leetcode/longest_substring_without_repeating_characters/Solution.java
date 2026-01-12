package com.andrew.smv.two_pointers.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

class Solution {


    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        int res = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {


            if (!characterIntegerMap.containsKey(s.charAt(i))) {
                characterIntegerMap.put(s.charAt(i), 1);
            } else {
                characterIntegerMap.computeIfPresent(s.charAt(i), (k, v) -> ++v);
            }

            while (characterIntegerMap.get(s.charAt(i)) > 1) {
                characterIntegerMap.computeIfPresent(s.charAt(l), (k, v) -> --v);
                l++;
            }

            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}