package org.example.commands;

import java.util.Set;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;
import org.example.services.AddUserDetailsServiceInterface;

public class AddUserCommand implements UserCommandInterface {
  private final AddUserDetailsServiceInterface addUserDetails;

  public AddUserCommand(AddUserDetailsServiceInterface addUserDetails) {
    this.addUserDetails = addUserDetails;
  }

  @Override
  public void execute(final Set<User> users) {
    try {
      User newUser = addUserDetails.addUser();
      if (users.stream().noneMatch(user -> user.getRollNumber().equals(newUser.getRollNumber()))) {
        users.add(newUser);
      } else {
        System.out.println("User with rollNo " + newUser.getRollNumber() + " already exists.");
      }
    } catch (InvalidArgument e) {
      System.out.println("Error adding user: " + e.getMessage());
    }
  }

}
