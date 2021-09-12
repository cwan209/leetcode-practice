package com.simple.binarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = 0;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            int pivotNumber = nums[pivot];

            if (pivotNumber == target) {
                return pivot;
            }

            if (pivotNumber > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }
}
