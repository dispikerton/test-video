package ru.ivanov.testvideo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static ru.ivanov.testvideo.StringUtils.isPalindrome;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;

class TestDynamic {

  Calculator calculator = new Calculator();

  @TestFactory
  Collection<DynamicTest> simpleDynamicTests() {
    return Arrays.asList(
      dynamicTest("1st dynamic test", () -> assertEquals(2, 1 + 1)),
      dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2)),
      dynamicTest("3rd dynamic test", () -> assertEquals(9, 3 * 3))
    );
  }

  @TestFactory
  Collection<DynamicTest> dynamicTestsFromCollection() {
    return Arrays.asList(
      dynamicTest("1st dynamic test", () -> assertTrue(isPalindrome("madam"))),
      dynamicTest("2nd dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
    );
  }

  @TestFactory
  Iterable<DynamicTest> dynamicTestsFromIterable() {
    return Arrays.asList(
      dynamicTest("3rd dynamic test", () -> assertTrue(isPalindrome("madam"))),
      dynamicTest("4th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
    );
  }

  @TestFactory
  Iterator<DynamicTest> dynamicTestsFromIterator() {
    return Arrays.asList(
      dynamicTest("5th dynamic test", () -> assertTrue(isPalindrome("madam"))),
      dynamicTest("6th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
    ).iterator();
  }

  @TestFactory
  Stream<DynamicTest> generateRandomNumberOfTestsFromIterator() {

    // Generates random positive integers between 0 and 100 until
    // a number evenly divisible by 7 is encountered.
    Iterator<Integer> inputGenerator = new Iterator<>() {

      final Random random = new Random();
      int current;

      @Override
      public boolean hasNext() {
        current = random.nextInt(100);
        return current % 7 != 0;
      }

      @Override
      public Integer next() {
        return current;
      }
    };

    // Generates display names like: input:5, input:37, input:85, etc.
    Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;

    // Executes tests based on the current input value.
    ThrowingConsumer<Integer> testExecutor = (input) -> assertNotEquals(0, input % 7);

    // Returns a stream of dynamic tests.
    return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
  }

  @TestFactory
  Stream<DynamicTest> dynamicTestsFromStreamFactoryMethod() {
    // Stream of palindromes to check
    Stream<String> inputStream = Stream.of("racecar", "radar", "mom", "dad");

    // Generates display names like: racecar is a palindrome
    Function<String, String> displayNameGenerator = text -> text + " is a palindrome";

    // Executes tests based on the current input value.
    ThrowingConsumer<String> testExecutor = text -> assertTrue(isPalindrome(text));

    // Returns a stream of dynamic tests.
    return DynamicTest.stream(inputStream, displayNameGenerator, testExecutor);
  }

  @TestFactory
  DynamicNode dynamicNodeSingleTest() {
    return dynamicTest("'pop' is a palindrome", () -> assertTrue(isPalindrome("pop")));
  }
}
