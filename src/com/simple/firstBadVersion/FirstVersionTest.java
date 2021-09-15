package com.simple.firstBadVersion;

import com.simple.firstBadVersion.FirstBadVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstVersionTest {


    @Test
    public void shouldReturnCorrectIndexWhenFound() {
        // given
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        // when
        Assertions.assertEquals(99, firstBadVersion.firstBadVersion(16000));
        Assertions.assertEquals(99, firstBadVersion.firstBadVersion(80011));
        Assertions.assertEquals(99, firstBadVersion.firstBadVersion(15999));
        Assertions.assertEquals(99, firstBadVersion.firstBadVersion(36545));
    }



}