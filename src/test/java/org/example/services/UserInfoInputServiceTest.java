package org.example.services;

import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserInfoInputServiceTest {

  private UserInfoInputService userInfoInputService;

  @Mock
  private Scanner mockScanner;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    userInfoInputService = new UserInfoInputService();
    userInfoInputService.scanner = mockScanner;
  }

  @Test
  public void testUserInfoInputPrompt() {
    when(mockScanner.nextLine()).thenReturn("Hirdesh Sharma")
        .thenReturn("25")
        .thenReturn("Bhind Daboha")
        .thenReturn("1234")
        .thenReturn("A B C");

    User user = userInfoInputService.createNewUser();

    assertEquals("Hirdesh Sharma", user.getName());
    assertEquals(25, user.getAge());
    assertEquals("Bhind Daboha", user.getAddress());
    assertEquals("1234", user.getRollNumber());
    assertEquals(3, user.getEnrolledCourses().length);
    assertEquals("A", user.getEnrolledCourses()[0]);
    assertEquals("B", user.getEnrolledCourses()[1]);
    assertEquals("C", user.getEnrolledCourses()[2]);
  }
}
