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

  @Test
  void testDivide() {
    Calculator calculator = new Calculator();
    int divide = calculator.divide(20, 4);
    Assertions.assertEquals(5, divide);
  }

  @Test
  void testDivideByZero() {
    Calculator calculator = new Calculator();
    Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(20, 0));
  }
}
