package org.example.validators;

import org.example.exceptions.InvalidArgument;

public class UserInteractionServiceValidator {

  public static void validateUserChoice(final int userChoice) {
    if (userChoice < 1 || userChoice > 5) {
      throw new InvalidArgument(
          "Invalid choice: " + userChoice + ". Choice should be between 1 and 5.");
    }
  }
}
