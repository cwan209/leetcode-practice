package com.simple.firstBadVersion;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int pivot = left + (right - left) / 2;

            if (isBadVersion(pivot)) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int pivot) {
        return pivot >= 99;
    }


}
