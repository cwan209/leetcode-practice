package com.simple.rotateArray;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int lastNumber = nums[nums.length - 1];
            int nextNumber = nums[0];
            int overwrittenNumber;

            for (int j = 0; j < nums.length; j++) {

                System.out.println(Arrays.toString(nums));

                if (j == nums.length - 1) {
                    nums[0] = lastNumber;
                } else {
                    overwrittenNumber = nums[j + 1];
                    nums[j + 1] = nextNumber;
                    nextNumber = overwrittenNumber;
                }
            }

            System.out.println("==========================");
            System.out.println(Arrays.toString(nums));
            System.out.println("==========================");

        }

    }
}
