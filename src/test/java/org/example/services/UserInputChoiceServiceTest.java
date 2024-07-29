package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserInputChoiceServiceTest {
  private UserInputChoiceService userInputChoiceService;
  @Mock
  Scanner mockScanner;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    userInputChoiceService = new UserInputChoiceService();
    userInputChoiceService.scanner = mockScanner;
  }

  @Test
  public void userChoice() {
    when(mockScanner.nextInt()).thenReturn(3);
    assertEquals(userInputChoiceService.userInputChoice(), 3);
  }

}