package org.example.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;
import org.example.model.User;
import org.example.services.AddUserDetailsServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddUserCommandTest {

  private AddUserDetailsServiceInterface addUserDetailsService;
  private UserCommandInterface addUserCommand;
  private Set<User> users;

  @BeforeEach
  public void setUp() {
    addUserDetailsService = mock(AddUserDetailsServiceInterface.class);
    addUserCommand = new AddUserCommand(addUserDetailsService);
    users = new HashSet<>();
  }

  @Test
  public void testExecute_addsNewUser() {
    User newUser = new User("Hirdesh Sharma", "1001", 25, "Bhind Daboha", new String[]{"A"});
    when(addUserDetailsService.addUser()).thenReturn(newUser);

    addUserCommand.execute(users);

    assertTrue(users.contains(newUser));
  }

  @Test
  public void testExecute_UserAlreadyExists() {
    User existingUser = new User("Hirdesh Sharma", "1001", 25, "Bhind Daboha", new String[]{"A"});
    users.add(existingUser);
    when(addUserDetailsService.addUser()).thenReturn(existingUser);

    addUserCommand.execute(users);

    // Verify that the user was not added again
    assertEquals(1, users.size());
  }
}
