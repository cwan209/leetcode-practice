package com.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AlgorithmsTests {

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
}
