package com.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Algorithms {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) return  new int[]{left + 1, right + 1};
            if (target > sum) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char leftChar = s[left];
            char rightChar = s[right];

            s[left++] = rightChar;
            s[right--] = leftChar;
        }
    }

    public String reverseWordsInString(String s) {
        List a = new LinkedList<String>();
        String[] words = s.split(" ");
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            char[] wordChars = words[i].toCharArray();
            reverseString(wordChars);
            for (char wordChar: wordChars) {
                stringBuilder.append(wordChar);
            }
            reversedWords[i] = stringBuilder.toString();
        }

        return String.join(" ", reversedWords);
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;
        int maxLength = 0;

        while (right <= s.length()) {
            int length = right - left;
            String subString = s.substring(left, right);
            if (isNonRepeating(subString)) {
                if (length > maxLength) maxLength = length;
                right++;
            } else {
                left++;
            }
        }

        return maxLength;
    }

    private boolean isNonRepeating(String s) {
        char[] chars = s.toCharArray();
        List<Character> existingChars = new ArrayList<>();
        for (char aChar : chars) {
            if (existingChars.contains(aChar)) {
                return false;
            } else {
                existingChars.add(aChar);
            }
        }
        return true;
    }
}
