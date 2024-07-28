package org.example.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.exceptions.InvalidArgument;
import org.example.validators.UserInteractionServiceValidator;
import org.junit.jupiter.api.Test;

class UserInteractionServiceValidatorTest {

  private final UserInteractionServiceValidator validator = new UserInteractionServiceValidator();

  @Test
  void testValidateUserChoiceValid() {
    assertDoesNotThrow(() -> validator.validateUserChoice(1));
    assertDoesNotThrow(() -> validator.validateUserChoice(3));
    assertDoesNotThrow(() -> validator.validateUserChoice(5));
  }

  @Test
  void testValidateUserChoiceTooLow() {
    assertThrows(InvalidArgument.class, () -> validator.validateUserChoice(0));
  }

  @Test
  void testValidateUserChoiceTooHigh() {
    assertThrows(InvalidArgument.class, () -> validator.validateUserChoice(6));
  }
}
