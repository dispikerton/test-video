package ru.ivanov.testvideo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestTimeout3 {
  @Test
  void testTimeout() throws InterruptedException {
    Thread.sleep(3000);
    assertTrue(true);
  }
}
