package org.example.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.Test;

public class CourseTypeTest {

  @Test
  public void testFromStringValidCourseType() {
    assertEquals(CourseType.A, CourseType.fromString("A"));
    assertEquals(CourseType.B, CourseType.fromString("B"));
  }

  @Test
  public void testFromStringValidCourseTypeLowerCase() {
    assertEquals(CourseType.A, CourseType.fromString("a"));
    assertEquals(CourseType.B, CourseType.fromString("b"));
  }

  @Test
  public void testFromStringNullType() {
    assertThrows(InvalidArgument.class, () -> CourseType.fromString(null));
  }

  @Test
  public void testFromStringInvalidCourseType() {
    assertThrows(InvalidArgument.class, () -> CourseType.fromString("G"));
  }
}
