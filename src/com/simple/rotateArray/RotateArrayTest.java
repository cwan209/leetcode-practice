package com.simple.rotateArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotateArrayTest {


    @Test
    public void shouldReturnCorrectIndexWhenFound() {
        // given
        int [] num = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        RotateArray r = new RotateArray();

        // when
        r.rotate(num, k);

        // then
        int [] expected = new int[] {5,6,7,1,2,3,4};
        Assertions.assertArrayEquals(expected, num);
    }



}