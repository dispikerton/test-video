package ru.ivanov.testvideo;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;

class TestRepeat {

  private static final int NUM_REPETITIONS = 100;

  private final Random random = new Random();

  @RepeatedTest(NUM_REPETITIONS)
  void testRandomNumberGenerator() {
    int randomNumber = random.nextInt(10);

    // Тест будет падать, если сгенерированное число меньше 1
    assertTrue(randomNumber >= 1,
      "Generated random number is less than 1.");
  }
}