package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInteractionServiceTest {
  private final InputStream originalSystemIn = System.in;
  @AfterEach
  public void tearDown() {
    System.setIn(originalSystemIn);
  }

  @Test
  public void testValidUserInput() {
    String input = "4\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInteractionService userInteractionService = new UserInteractionService();

    assertEquals(4, userInteractionService.displayMenuAndGetUserChoice());
  }
  @Test
  public void testInvalidUserInput() {
    String input = "4a\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInteractionService userInteractionService = new UserInteractionService();
    assertThrows(InvalidArgument.class, ()->userInteractionService.displayMenuAndGetUserChoice());
  }
  @Test
  public void outOfBoundsUserInput() {
    String input = "8";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInteractionService userInteractionService = new UserInteractionService();
    assertThrows(InvalidArgument.class, ()->userInteractionService.displayMenuAndGetUserChoice());
  }
}
