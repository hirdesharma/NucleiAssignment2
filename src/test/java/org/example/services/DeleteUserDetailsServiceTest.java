package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteUserDetailsServiceTest {

  private DeleteUserDetailsService deleteUserDetailsService;

  @BeforeEach
  void setUp() {
    deleteUserDetailsService = new DeleteUserDetailsService();
  }

  @Test
  void testDeleteUserSuccess() {
    Set<User> users = new HashSet<>();
    User user = new User("Hirdesh Sharma", "123", 20, "Bhind Daboha",
        new String[]{"A", "B", "C", "E"});
    users.add(user);

    String simulatedInput = "123\n";
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    deleteUserDetailsService.deleteUser(users);
    assertTrue(users.isEmpty());
  }

  @Test
  void testDeleteUserNotFound() {
    Set<User> users = new HashSet<>();
    User user = new User("Hirdesh Sharma", "123", 20, "Bhind Daboha",
        new String[]{"A", "B", "C", "E"});
    users.add(user);

    String simulatedInput = "999\n";
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    deleteUserDetailsService.deleteUser(users);
    System.setOut(originalOut);

    String expectedOutput
        = "Enter RollNo Which you want to delete\n\nUser with rollNo : 999 Not Found";
    String actualOutput = outputStream.toString().trim();

    expectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
    actualOutput = actualOutput.replace("\r\n", "\n").replace("\r", "\n");

    assertEquals(expectedOutput, actualOutput);
  }
}
