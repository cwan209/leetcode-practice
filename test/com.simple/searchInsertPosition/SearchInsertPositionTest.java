package com.simple.searchInsertPosition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchInsertPositionTest {

    @Test
    public void shouldReturnCorrectIndexWhenFound() {
        // given
        SearchInsertPosition s = new SearchInsertPosition();

        int[] nums = new int[] {1,3,5,6};
        // when
        Assertions.assertEquals(2, s.searchInsert(nums, 5));
        Assertions.assertEquals(1, s.searchInsert(nums, 2));
        Assertions.assertEquals(4, s.searchInsert(nums, 7));
        Assertions.assertEquals(0, s.searchInsert(nums, 0));
        Assertions.assertEquals(0, s.searchInsert(nums, 0));
    }
}