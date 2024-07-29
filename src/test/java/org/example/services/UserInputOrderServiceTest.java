package org.example.services;

import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputOrderServiceTest {

  private final InputStream originalSystemIn = System.in;

  @Test
  public void testUserInputOrderAscending() {
    String input = "1\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInputOrderService service = new UserInputOrderService();
    System.setIn(originalSystemIn);
    assertEquals(1, service.userInputOrder());
  }

  @Test
  public void testUserInputOrderDescending() {
    String input = "2\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInputOrderService service = new UserInputOrderService();
    System.setIn(originalSystemIn);
    assertEquals(2, service.userInputOrder());
  }

  @Test
  public void testUserInputOrderInvalid() {
    String input = "invalid\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    UserInputOrderService service = new UserInputOrderService();
    System.setIn(originalSystemIn);
    assertThrows(InvalidArgument.class, service::userInputOrder);
  }
}
