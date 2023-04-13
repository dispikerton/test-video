package ru.ivanov.testvideo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestTimeout {

    @Test
    @Timeout(1)
    void testTimeout() throws InterruptedException {
        Thread.sleep(1100);
        assertTrue(true);
    }
}
