package com.simple.squareOfSortedArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstVersionTest {


    @Test
    public void shouldReturnCorrectIndexWhenFound() {
        // given
        SquareOfSortedArray s = new SquareOfSortedArray();
        // when
        Assertions.assertArrayEquals(new int[] {0,1,9,16,100}, s.sortedSquares(new int[] {-4,-1,0,3,10}));
    }
}