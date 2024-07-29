package org.example.services;

import java.util.Scanner;
import org.example.exceptions.InvalidArgument;

public class UserInputOrderService {
  Scanner scanner = new Scanner(System.in);

  public int userInputOrder() {
    System.out.println("1. Ascending order ");
    System.out.println("2. Descending order");
    System.out.print("Enter choice : ");
    return getUserInputOrder();
  }

  public int getUserInputOrder() {
    try{
      int userInput = scanner.nextInt();
      return userInput;
    }catch (Exception e){
      throw new InvalidArgument("userInput should be a valid integer");
    }
  }
}
