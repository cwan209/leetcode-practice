package com.simple.squareOfSortedArray;

import java.util.Arrays;

public class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        // approach 1
        int[] squaredArray = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        int maxIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            int leftAbsolute = getAbsoluteNumber(nums[left]);
            System.out.println(leftAbsolute);
            int rightAbsolute = getAbsoluteNumber(nums[right]);
            System.out.println(rightAbsolute);

            if (leftAbsolute < rightAbsolute) {
                squaredArray[maxIndex] = rightAbsolute * rightAbsolute;
                right--;
            } else {
                squaredArray[maxIndex] = leftAbsolute * leftAbsolute;
                left++;

            }
            maxIndex--;
        }
        System.out.println(Arrays.toString(squaredArray));
        return squaredArray;
    }

    private int getAbsoluteNumber(int number) {
        return number < 0 ? -number : number;
    }
}
