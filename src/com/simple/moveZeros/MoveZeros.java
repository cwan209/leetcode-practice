package com.simple.moveZeros;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                nums[i - zeros] = nums[i];
            }
        }

        for (int i = 0; i < zeros; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
}
