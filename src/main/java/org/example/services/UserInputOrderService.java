package org.example.services;

import java.util.Scanner;

public class UserInputOrderService {
  Scanner scanner = new Scanner(System.in);

  public int userInputOrder() {
    System.out.println("1. Ascending order ");
    System.out.println("2. Descending order");
    System.out.print("Enter choice : ");
    return getUserInputOrder();
  }

  public int getUserInputOrder() {
    try {
      int userInput = scanner.nextInt();
      return userInput;
    } catch (Exception e) {
      System.out.println("Invalid input. Please enter a valid integer.");
      scanner.next(); // Clear invalid input
      return getUserInputOrder(); // Retry input
    }
  }
}
