package ru.ivanov.testvideo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestTimeout4 {
  @Test
  void testTimeout1() throws InterruptedException {
    Thread.sleep(3000);
    assertTrue(true);
  }
}
