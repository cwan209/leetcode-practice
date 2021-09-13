package com.simple.firstBadVersion;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int pivot = 0;
        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (pivot == left || pivot == right) {
                if (isBadVersion(pivot)) return pivot;
                else return pivot + 1;
            }

            System.out.println("pivot： " + pivot);
            if (isBadVersion(pivot)) {
                right = pivot;
                System.out.println("right： " + right);
            } else {
                left = pivot;
                System.out.println("left： " + left);
            }
        }
        return pivot;
    }

    private boolean isBadVersion(int pivot) {
        return pivot >= 99;
    }


}
