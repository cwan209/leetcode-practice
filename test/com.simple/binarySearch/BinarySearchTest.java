package com.simple.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {


    @Test
    public void shouldReturnCorrectIndexWhenFound() {
        // given
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[] {-1,0,3,5,9,12};
        int target = 9;
        // when
        Assertions.assertEquals(4, binarySearch.search(nums, target));
    }

    @Test
    public void shouldReturnCorrectIndexWhenNotFound() {
        // given
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[] {-1,0,3,5,9,12};
        int target = 2;
        // when
        Assertions.assertEquals(-1, binarySearch.search(nums, target));
    }


}