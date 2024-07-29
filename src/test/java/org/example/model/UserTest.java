package org.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
  private User user1;
  private User user2;
  private User user3;

  @BeforeEach
  public void setUp() {
    user1 = new User("Great khali", "123", 25, "ward 8 , daboha  bhind", new String[]{"A", "B", "C"
        , "D"});
  }

  @Test
  public void testGetName() {
    assertEquals("Great khali", user1.getName());
  }

  @Test
  public void testGetAge() {
    assertEquals(25, user1.getAge());
  }

  @Test
  public void testGetAddress() {
    assertEquals("ward 8 , daboha  bhind", user1.getAddress());
  }

  @Test
  public void testGetRollNumber() {
    assertEquals("123", user1.getRollNumber());
  }

  @Test
  public void testGetEnrolledCourses() {
    assertTrue(Arrays.equals(new String[]{"A", "B", "C", "D"}, user1.getEnrolledCourses()));
  }

  @Test
  public void testDisplay() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    user1.display();
    System.setOut(originalOut);

    String expectedOutput
        =
        "User { name = 'Great khali', rollNumber = '123', age = 25, address = 'ward 8 , daboha  "
            + "bhind' "
            + "enrolled courses = [A, B, C, D] }";
    assertEquals(expectedOutput, outputStream.toString().trim());
  }
}
