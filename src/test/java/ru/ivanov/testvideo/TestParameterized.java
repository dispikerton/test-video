package ru.ivanov.testvideo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestParameterized {

  @ParameterizedTest
  @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
  void palindromes(String candidate) {
    assertTrue(StringUtils.isPalindrome(candidate));
  }
}
