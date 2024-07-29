package org.example.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InvalidArgumentTest {

  @Test
  public void testInvalidArgumentMessage() {
    String errorMessage = "Invalid argument provided sir 🫡";
    InvalidArgument exception = new InvalidArgument(errorMessage);
    assertEquals(errorMessage, exception.getMessage());
  }

  @Test
  public void testInvalidArgumentThrowsException() {
    String errorMessage = "This is a test exception bro 🫡";
    assertThrows(InvalidArgument.class, () -> {
      throw new InvalidArgument(errorMessage);
    }, errorMessage);
  }
}
