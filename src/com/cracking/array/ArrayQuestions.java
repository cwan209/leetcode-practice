package com.cracking.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayQuestions {

    //    Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    //    cannot use additional data structures?
    public boolean isUnique(String str) {
        if (str.length() > 128) return false;
        boolean[] charsAppeared = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); // char can be assigned to integer directly
            System.out.println(val);
            if (charsAppeared[val]) return false;
            charsAppeared[val] = true;
        }
        return true;
    }

    //    Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    //    other.
    public boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        var charSet1 = new int[128];
        var charSet2 = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            int charIndex = str1.charAt(i);
            charSet1[charIndex]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int charIndex = str2.charAt(i);
            charSet2[charIndex]++;
        }

        for (int i = 0; i < charSet1.length; i++) {
            if (charSet1[i] != charSet2[i]) return false;
        }
        return true;
    }

    // Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    // A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    // is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    public boolean isPalindrome(String str) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') stringBuilder.append(c);
        }

        str = stringBuilder.toString();
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            char left = str.charAt(i);
            char right = str.charAt(length - i - 1);

            if (left != right) {
                return false;
            }
        }

        return true;
    }

    // Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    // A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    // is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    public boolean isPermutationOfPalindrome(String str) {
        var charCount = new HashMap<Character, Integer>();

        for (char c: str.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        int oddCount = 0;
        for (var entry: charCount.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) oddCount++;
        }

        return oddCount <= 1;
    }

    public boolean isOneEditAway(String str1, String str2) {
        int smallerLength = Math.max(str1.length(), str2.length());

        int[] charCount1 = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int index = str1.charAt(i);
            charCount1[index]++;
        }

        int[] charCount2 = new int[128];
        for (int i = 0; i < str2.length(); i++) {
            int index = str2.charAt(i);
            charCount2[index]++;
        }

        int sameInTotal = 0;
        for (int i = 0; i < charCount1.length; i++) {
            if (charCount1[i] != 0 && charCount1[i] == charCount2[i]) sameInTotal++;
        }

        return sameInTotal == smallerLength;
    }

    // Implement a method to perform basic string compression using the counts
    // of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    // "compressed" string would not become smaller than the original string, your method should return
    // the original string. You can assume the string has only uppercase and lowercase letters (a - z)
    public String compress(String str) {
        boolean hasDup = false;
        var stringBuilder = new StringBuilder();
        char previousChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == str.length() - 1) {
                count++;
                stringBuilder.append(previousChar);
                stringBuilder.append(count);
            } else if (c == previousChar) {
                count++;
                hasDup = true;
            } else {
                stringBuilder.append(previousChar);
                stringBuilder.append(count);
                count = 1;
            }
            previousChar = c;
        }

        if (hasDup) return stringBuilder.toString();
        return str;
    }

    public char[][] rotateMatrixBy90Degree(char[][] matrix) {
        int x = matrix.length;
        int y = matrix[1].length;
        int centerX = (x - 1) / 2 ;
        int centerY = (y - 1) / 2 ;

        // single layer doesn't need rotation
        int noOfLayers = x / 2;

        for (int layer = 0; layer < noOfLayers; layer++) {
            // 0,0 -> 0,2
            // 0,1 -> 1,2

            int first = layer;
            int last = x - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];


            }

        }
        return matrix;
    }

    //  Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    //  column are set to O.
    public int[][] zeroMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        var zeroCoordinates = new ArrayList<Pair>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) zeroCoordinates.add(new Pair(i, j));
            }
        }

        for (Pair coord: zeroCoordinates) {
            int x = coord.getLeft();
            int y = coord.getRight();

            for (int i = 0; i < n; i++) {
                matrix[x][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                matrix[i][y] = 0;
            }
        }

        return matrix;
    }

    public boolean isRotatedString(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int length = str1.length();

        for (int i = 0; i < length; i++) {
            String left = str1.substring(0, i);
            String right = str1.substring(i, length);
            String newStr = right + left;
            if (newStr.equals(str2)) return true;
        }

        return false;
    }

    public class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
