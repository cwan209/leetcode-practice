package com.simple.moveZeros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveZerosTest {

    @Test
    public void shouldReturnCorrectIndexWhenFound() {
        // given
        int [] input = new int[] {0,1,0,3,12};
        MoveZeros m = new MoveZeros();

        // when
        m.moveZeroes(input);

        // then
        int [] expected = new int[] {1,3,12,0,0};
        Assertions.assertArrayEquals(expected, input);
    }
}