package com.cracking.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQuestionsTest {
    ArrayQuestions arrayQuestions = new ArrayQuestions();

    @Test
    void isUnique() {
        assertTrue(arrayQuestions.isUnique("abcde"));
        assertFalse(arrayQuestions.isUnique("aabcd"));
    }

    @Test
    void checkPermutation() {
        assertTrue(arrayQuestions.checkPermutation("abcde", "edcba"));
        assertFalse(arrayQuestions.checkPermutation("abcde", "acewq"));
    }

    @Test
    void isPalindrome() {
        assertTrue(arrayQuestions.isPalindrome("taco cat"));
        assertTrue(arrayQuestions.isPalindrome("atco cta"));
        assertFalse(arrayQuestions.isPalindrome("abcd e"));
    }

    @Test
    void isPalindromeOfPermutation() {
        assertTrue(arrayQuestions.isPermutationOfPalindrome("ttaacco"));
        assertFalse(arrayQuestions.isPermutationOfPalindrome("atco ctfffa"));
    }

    @Test
    void isOneEditAway() {
        assertTrue(arrayQuestions.isOneEditAway("pale", "ple"));
        assertTrue(arrayQuestions.isOneEditAway("pales", "pales"));
        assertTrue(arrayQuestions.isOneEditAway("pale", "bale"));
        assertFalse(arrayQuestions.isOneEditAway("pale", "bake"));
    }

    @Test
    void compress() {
        assertEquals("a2b1c5a3", arrayQuestions.compress("aabcccccaaa"));
        assertEquals("a2b1c5a3e3", arrayQuestions.compress("aabcccccaaaeee"));
        assertEquals("abcde", arrayQuestions.compress("abcde"));
    }

    @Test
    void rotateMatrix() {
        var beforeRotation = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
        };

        var afterRotation = new char[][]{
            {'g', 'd', 'a'},
            {'h', 'e', 'b'},
            {'i', 'f', 'c'},
        };

        assertEquals(afterRotation, arrayQuestions.rotateMatrixBy90Degree(beforeRotation));
    }

    @Test
    void zeroMatrix() {
        var beforeRotation = new int[][]{
            {1, 2, 0},
            {1, 2, 3},
            {1, 2, 0},
        };

        var afterRotation = new int[][]{
            {0, 0, 0},
            {1, 2, 0},
            {0, 0, 0},
        };

        assertArrayEquals(afterRotation, arrayQuestions.zeroMatrix(beforeRotation));
    }

    @Test
    void rotateString() {
        assertTrue(arrayQuestions.isRotatedString("erbottlewat", "waterbottle"));
        assertFalse(arrayQuestions.isRotatedString("erbottlew", "waterbottle"));
    }
}