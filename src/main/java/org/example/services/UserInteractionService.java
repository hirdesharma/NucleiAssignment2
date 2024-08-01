package org.example.services;

import java.util.Scanner;
import org.example.prompt.MenuPrompt;
import org.example.validators.UserInteractionServiceValidator;

public class UserInteractionService implements UserInteractionServiceInterface {
  private int userChoice;

  Scanner scanner = new Scanner(System.in);
  MenuPrompt menuPrompt = new MenuPrompt();

  @Override
  public int displayMenuAndGetUserChoice() {
    menuPrompt.showMenu();
    return getUserChoice();
  }

  private int getUserChoice() {
    try {
      userChoice = scanner.nextInt();
    } catch (Exception e) {
      System.out.println("Invalid input. Please enter a valid integer.");
      scanner.next(); // Clear invalid input
      return getUserChoice(); // Retry input
    }
    UserInteractionServiceValidator.validateUserChoice(userChoice);
    return userChoice;
  }
}
