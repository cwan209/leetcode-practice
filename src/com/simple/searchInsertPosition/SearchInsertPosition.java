package com.simple.searchInsertPosition;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target > nums[right]) return nums.length;

        while (left < right) {
            int pivot = left + (right - left) / 2;
            int number = nums[pivot];

            System.out.println(pivot);
            System.out.println(number);

            if (target > number) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        return left;
    }
}
