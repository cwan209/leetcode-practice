package com.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AlgorithmsTests {

    private Algorithms algorithms;

    @BeforeEach
    public void setUp() {
        algorithms = new Algorithms();
    }

    /**
        Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
        Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
        The tests are generated such that there is exactly one solution. You may not use the same element twice.

        Example 1:

        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
        Example 2:

        Input: numbers = [2,3,4], target = 6
        Output: [1,3]
        Example 3:

        Input: numbers = [-1,0], target = -1
        Output: [1,2]


        Constraints:

                2 <= numbers.length <= 3 * 104
                -1000 <= numbers[i] <= 1000
        numbers is sorted in non-decreasing order.
                -1000 <= target <= 1000
        The tests are generated such that there is exactly one solution.
     ***/
    @Test void twoSum() {
        // given
        Algorithms algorithms = new Algorithms();
        int[] input = new int[]{2,7,11,15};
        int target = 9;
        int[] output = new int[]{1,2};

        // when
        int[] result = algorithms.twoSum(input, target);

        // then
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(output, result);
    }

    /**
     Write a function that reverses a string. The input string is given as an array of characters s.
     Example 1:

     Input: s = ["h","e","l","l","o"]
     Output: ["o","l","l","e","h"]
     Example 2:

     Input: s = ["H","a","n","n","a","h"]
     Output: ["h","a","n","n","a","H"]


     Constraints:

     1 <= s.length <= 105
     s[i] is a printable ascii character.
     ***/
    @Test void reverseString() {
        // given
        Algorithms algorithms = new Algorithms();
        char[] hello = new char[]{'h', 'e', 'l', 'l', 'o'};

        // when
        algorithms.reverseString(hello);

        // then
        Assertions.assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, hello);
    }

    /**
     Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

     Example 1:

     Input: s = "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"
     Example 2:

     Input: s = "God Ding"
     Output: "doG gniD"

     Constraints:

     1 <= s.length <= 5 * 104
     s contains printable ASCII characters.
     s does not contain any leading or trailing spaces.
     There is at least one word in s.
     All the words in s are separated by a single space.
     ***/
    @Test void reverseWordsInString() {
        // when
        String result = algorithms.reverseWordsInString("Let's take LeetCode contest");

        // then
        Assertions.assertEquals("s'teL ekat edoCteeL tsetnoc", result);
    }

    /**
     Given a string s, find the length of the longest substring without repeating characters.

     Example 1:

     Input: s = "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.
     Example 2:

     Input: s = "bbbbb"
     Output: 1
     Explanation: The answer is "b", with the length of 1.
     Example 3:

     Input: s = "pwwkew"
     Output: 3
     Explanation: The answer is "wke", with the length of 3.
     Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     Example 4:

     Input: s = ""
     Output: 0

     ***/
    @Test void lengthOfLongestSubstring() {

        // then
        Assertions.assertEquals(3, algorithms.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, algorithms.lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, algorithms.lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(0, algorithms.lengthOfLongestSubstring(""));
    }

    /**
     Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

     In other words, return true if one of s1's permutations is the substring of s2.

     Example 1:

     Input: s1 = "ab", s2 = "eidbaooo"
     Output: true
     Explanation: s2 contains one permutation of s1 ("ba").
     Example 2:

     Input: s1 = "ab", s2 = "eidboaoo"
     Output: false

     Constraints:

     1 <= s1.length, s2.length <= 104
     s1 and s2 consist of lowercase English letters.

     ***/
    @Test void perm() {
        Assertions.assertTrue(algorithms.checkInclusion("abo", "eidbaooo"));
        Assertions.assertFalse(algorithms.checkInclusion("ab", "eidboaoo"));
        Assertions.assertTrue(algorithms.checkInclusion("adc", "dcda"));
        Assertions.assertFalse(algorithms.checkInclusion("ab", "a"));
    }

    /**
     An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

     You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

     To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

     Return the modified image after performing the flood fill.

     Example 1:

     Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
     Output: [[2,2,2],[2,2,0],[2,0,1]]
     Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
     Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
     Example 2:

     Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
     Output: [[2,2,2],[2,2,2]]
     ***/
    @Test void floodFill() {
        int[][] image = new int[][]{new int[] {1,1,1},new int[] {1,1,0},new int[] {1,0,1}};
        int[][] filledImage = new int[][]{new int[] {2,2,2},new int[] {2,2,0},new int[] {2,0,1}};
        Assertions.assertArrayEquals(filledImage, algorithms.floodFill(image, 1, 1, 2));
    }

    /**
     You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

     The area of an island is the number of cells with a value 1 in the island.

     Return the maximum area of an island in grid. If there is no island, return 0.

     Example 1:
     Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     Output: 6
     Explanation: The answer is not 11, because the island must be connected 4-directionally.

     Example 2:
     Input: grid = [[0,0,0,0,0,0,0,0]]
     Output: 0
     ***/
    @Test void maxAreaOfIsland() {
        int[][] grid  = new int[][]{
            new int[] {0,0,1,0,0,0,0,1,0,0,0,0,0},
            new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0},
            new int[] {0,1,1,0,1,0,0,0,0,0,0,0,0},
            new int[] {0,1,0,0,1,1,0,0,1,0,1,0,0},
            new int[] {0,1,0,0,1,1,0,0,1,1,1,0,0},
            new int[] {0,0,0,0,0,0,0,0,0,0,1,0,0},
            new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0},
            new int[] {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Assertions.assertEquals(6, algorithms.maxAreaOfIsland(grid));
    }

    /**
     You are given two binary trees root1 and root2.
     Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
     Return the merged tree.
     Note: The merging process must start from the root nodes of both trees.

     Example 1:
     Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     Output: [3,4,5,5,4,null,7]

     Example 2:
     Input: root1 = [1], root2 = [1,2]
     Output: [2,2]
     ***/
    @Test void mergeTrees() {
    }

    @Test void mergeArrays() {
        int [] arr1 = new int[] {1,3 ,4, 5};
        int [] arr2 = new int[] {2,6,7,8};
        int [] expected = new int[] {1,2,3,4,5,6,7,8};

        Assertions.assertEquals(expected, algorithms.mergeArrays(arr1, arr2));

    }
}
