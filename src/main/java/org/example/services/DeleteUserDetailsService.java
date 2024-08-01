package org.example.services;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.example.model.User;

public class DeleteUserDetailsService implements DeleteUserDetailsServiceInterface {

  @Override
  public void deleteUser(final Set<User> users) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter RollNo Which you want to delete");
    String rollNo = scanner.nextLine();

    deleteUserByRollNo(users, rollNo);
  }

  private void deleteUserByRollNo(final Set<User> users, final String rollNo) {
    Iterator<User> iterator = users.iterator();
    while (iterator.hasNext()) {
      User user = iterator.next();
      if (user.getRollNumber().equals(rollNo)) {
        iterator.remove();
        return;
      }
    }
    System.out.println("\nUser with rollNo : " + rollNo + " Not Found");
  }
}
