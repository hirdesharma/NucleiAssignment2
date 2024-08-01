package org.example.services;

import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputOrderServiceTest {

  private final InputStream originalSystemIn = System.in;

  @BeforeEach
  public void setUp() {
    // Save the original System.in to restore later
    System.setIn(originalSystemIn);
  }

  @AfterEach
  public void tearDown() {
    // Restore original System.in after each test
    System.setIn(originalSystemIn);
  }

  @Test
  public void testUserInputOrderAscending() {
    String input = "1\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInputOrderService service = new UserInputOrderService();
    assertEquals(1, service.userInputOrder());
  }

  @Test
  public void testUserInputOrderDescending() {
    String input = "2\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInputOrderService service = new UserInputOrderService();
    assertEquals(2, service.userInputOrder());
  }

  @Test
  public void testUserInputOrderInvalid() {
    String input = "invalid\n1\n"; // Invalid input followed by valid input
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInputOrderService service = new UserInputOrderService();
    System.setIn(originalSystemIn);
    assertEquals(1, service.userInputOrder()); // Expecting it to return 1 after retry
  }

}
