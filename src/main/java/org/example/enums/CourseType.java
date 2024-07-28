package org.example.enums;

import java.util.Objects;
import org.example.exceptions.InvalidArgument;

public enum CourseType {
  A,
  B,
  C,
  D,
  E,
  F;

  public static CourseType fromString(final String type) {
    if (Objects.isNull(type)) {
      throw new InvalidArgument("Item type cannot be null");
    }
    try {
      return CourseType.valueOf(type.toUpperCase());
    } catch (Exception e) {
      throw new InvalidArgument("Invalid item type: " + type);
    }
  }
}
