package com.simple.binarySearch;

import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        System.out.println("\ntarget " + target);
        System.out.println("nums " + Arrays.toString(nums));


        int midIndex = nums.length / 2;
        System.out.println("midIndex " + midIndex);
        int midNumber = nums[midIndex];
        System.out.println("midNumber " + midNumber);


        if (midNumber == target) {
            return midIndex;
        }
        if (nums.length == 1) return -1;

        if (midNumber > target) {
            // the target number is in the first half
            int[] startToMidArray = Arrays.copyOfRange(nums, 0, midIndex);
            System.out.println("first half " + midIndex);

            return search(startToMidArray, target);
        } else {
            // the target number is in the second half
            int[] midToEndArray = Arrays.copyOfRange(nums, midIndex, nums.length);
            System.out.println("second half " + midIndex);
            int indexFound = search(midToEndArray, target);
            return indexFound == -1 ? indexFound : midIndex + indexFound;
        }
    }
}
