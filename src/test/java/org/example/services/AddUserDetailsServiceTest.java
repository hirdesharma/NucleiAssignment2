package org.example.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    addUserDetailsService.setFullName("Hirdesh Sharma");
    addUserDetailsService.setAge(25);
    addUserDetailsService.setAddress("Bhind Daboha");
    addUserDetailsService.setRollNo("A123");
    addUserDetailsService.setSetOfCourses(new String[]{"A", "B", "C", "D"});

    User user = addUserDetailsService.setNewUser();

    assertNotNull(user);
    assertEquals("Hirdesh Sharma", user.getName());
    assertEquals(25, user.getAge());
    assertEquals("Bhind Daboha", user.getAddress());
    assertEquals("A123", user.getRollNumber());
    assertEquals(4, user.getEnrolledCourses().length);
  }

  @Test
  void testNewUserWithInvalidDetails() {
    addUserDetailsService.setFullName("");
    addUserDetailsService.setAge(-1);
    addUserDetailsService.setAddress("");
    addUserDetailsService.setRollNo("");
    addUserDetailsService.setSetOfCourses(new String[]{});

    assertThrows(
        InvalidArgument.class,
        () -> addUserDetailsService.newUser()
    );
  }
}
