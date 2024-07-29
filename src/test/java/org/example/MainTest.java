package org.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.example.services.UserManager;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void testCreateUserManager() {
    UserManager userManager = Main.createUserManager();
    assertNotNull(userManager, "UserManager should not be null");
  }
}
