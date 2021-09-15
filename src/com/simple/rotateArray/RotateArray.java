package com.simple.rotateArray;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        int overwrittenNumberIndex;

        int[] tempArray = Arrays.copyOf(nums, nums.length);

        for (int j = 0; j < nums.length; j++) {
            overwrittenNumberIndex = j + k > n - 1 ? j + k - n : j + k;
            nums[overwrittenNumberIndex] = tempArray[j];
            System.out.println(Arrays.toString(nums));
        }

        System.out.println("==========================");
        System.out.println(Arrays.toString(nums));
        System.out.println("==========================");


    }
}
