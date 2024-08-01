package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddUserDetailsServiceTest {

  private AddUserDetailsService addUserDetailsService;

  @BeforeEach
  void setUp() {
    addUserDetailsService = new AddUserDetailsService();
  }

  @Test
  void testNewUserWithValidDetails() {
    String input = "Hirdesh Sharma\n25\nBhind Daboha\nA123\nA B C D\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    User user = addUserDetailsService.addUser();

    assertNotNull(user);
    assertEquals("Hirdesh Sharma", user.getName());
    assertEquals(25, user.getAge());
    assertEquals("Bhind Daboha", user.getAddress());
    assertEquals("A123", user.getRollNumber());
    assertEquals(4, user.getEnrolledCourses().length);
  }

  @Test
  void testNewUserWithInvalidDetails() {
    String input = "\n-1\n\n\n\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    assertThrows(
        InvalidArgument.class,
        () -> addUserDetailsService.addUser()
    );
  }
}
