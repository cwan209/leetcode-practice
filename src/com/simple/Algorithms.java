package com.simple;

import java.util.*;

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
        int right = 0;
        int[] chars = new int[128];

        int res = 0;
        while(right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                // there's duplicate
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] s1Chars = s1.toCharArray();
        int[] s1Map = new int[128];
        for (char c: s1Chars) {
            s1Map[c]++;
        }

        int windowLength = s1.length();

        char[] s2Chars = s2.toCharArray();
        int[] s2Map = new int[128];
        for (int i = 0; i < windowLength; i++) {
            s2Map[s2Chars[i]]++;
        }

        int left = 0;
        while ((left + windowLength) <= s2.length()) {
            if (left != 0) {
                s2Map[s2Chars[left - 1]]--;
                s2Map[s2Chars[left + windowLength - 1]]++;
            }
            if (Arrays.equals(s1Map, s2Map)) return true;
            left++;
        }

        return false;
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (newColor != originalColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (color == image[sr][sc]) {
            image[sr][sc] = newColor;
            if (sr - 1 >= 0) dfs(image, sr - 1, sc,color, newColor);
            if (sc - 1 >= 0) dfs(image, sr, sc - 1,color, newColor);
            if (sr + 1 < image[0].length) dfs(image, sr + 1, sc,color, newColor);
            if (sc + 1 < image.length) dfs(image, sr, sc + 1,color, newColor);
        }
    }


}
