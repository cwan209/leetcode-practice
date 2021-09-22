package com.simple;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    public String reverseWordsInString(String s) {
        List a = new LinkedList<String>();
        String[] words = s.split(" ");
        String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            char[] wordChars = words[i].toCharArray();
            reverseString(wordChars);
            for (char wordChar: wordChars) {
                stringBuilder.append(wordChar);
            }
            reversedWords[i] = stringBuilder.toString();
        }

        return String.join(" ", reversedWords);
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] chars = new int[128];

        int res = 0;
        while(right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                // there's duplicate
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] s1Chars = s1.toCharArray();
        int[] s1Map = new int[128];
        for (char c: s1Chars) {
            s1Map[c]++;
        }

        int windowLength = s1.length();

        char[] s2Chars = s2.toCharArray();
        int[] s2Map = new int[128];
        for (int i = 0; i < windowLength; i++) {
            s2Map[s2Chars[i]]++;
        }

        int left = 0;
        while ((left + windowLength) <= s2.length()) {
            if (left != 0) {
                s2Map[s2Chars[left - 1]]--;
                s2Map[s2Chars[left + windowLength - 1]]++;
            }
            if (Arrays.equals(s1Map, s2Map)) return true;
            left++;
        }

        return false;
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (newColor != originalColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (color == image[sr][sc]) {
            image[sr][sc] = newColor;
            if (sr - 1 >= 0) dfs(image, sr - 1, sc,color, newColor);
            if (sc - 1 >= 0) dfs(image, sr, sc - 1,color, newColor);
            if (sr + 1 < image[0].length) dfs(image, sr + 1, sc,color, newColor);
            if (sc + 1 < image.length) dfs(image, sr, sc + 1,color, newColor);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] foundIslands = new boolean[grid.length][grid[0].length];
        int maxSizeIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];

            for (int j = 0; j < row.length; j++) {
                int pixel = row[j];
                if (pixel != 0 ) {
                    int islandSize = findAdjacentIslands(i, j, grid, foundIslands);
                    maxSizeIsland = Math.max(islandSize, maxSizeIsland);
                }

            }
        }
        return maxSizeIsland;
    }

    private int findAdjacentIslands(int i, int j, int[][] grid, boolean[][] foundIslands) {
        int area = 0;
        if (grid[i][j] == 1) {
            foundIslands[i][j] = true;
            area++;

            if (i > 1 && !foundIslands[i - 1][j] ) area += findAdjacentIslands(i - 1, j, grid, foundIslands);
            if (j > 1 && !foundIslands[i][j - 1] ) area += findAdjacentIslands(i, j - 1, grid, foundIslands);
            if (i + 1 < grid.length && !foundIslands[i + 1][j]) area += findAdjacentIslands(i + 1, j, grid, foundIslands);
            if (j + 1 < grid[0].length && !foundIslands[i][j + 1]) area += findAdjacentIslands(i, j + 1, grid, foundIslands);

        }
        return area;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) root1 = root2;
        mergeNextNode(root1, root2);
        return root1;
    }

    private void mergeNextNode(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            node1.val = node1.val + node2.val;

            if (node1.left != null || node2.left != null) {
                mergeNextNode(node1.left, node2.left);
            }
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if (node1.right != null || node2.right != null) {
                mergeNextNode(node1.right, node2.right);
            }
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }

        }
    }


}
