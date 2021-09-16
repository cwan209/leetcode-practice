package com.simple;

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
}
