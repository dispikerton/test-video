package ru.ivanov.testvideo;

public class StringUtils {

  private StringUtils() {
    throw new IllegalStateException("Utility class");
  }

  public static boolean isPalindrome(String candidate) {
    return candidate.contentEquals(new StringBuilder(candidate).reverse());
  }
}
