package ru.ivanov.testvideo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void testMultiply() {
    Calculator calculator = new Calculator();
    int multiply = calculator.multiply(5, 4);
    Assertions.assertEquals(20, multiply);
  }
}
