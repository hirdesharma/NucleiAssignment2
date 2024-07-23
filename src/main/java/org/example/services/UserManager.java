package org.example.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.example.commands.AddUserCommand;
import org.example.commands.DeleteUserCommand;
import org.example.commands.SortUserCommand;
import org.example.commands.UserCommandInterface;
import org.example.model.User;

public class UserManager implements UserManagerInterface {
  public Set<User> users;
  private final UserInteractionServiceInterface userInteractionService;
  private final Map<Integer, UserCommandInterface> commandMap;
  private boolean terminateProgram = false;

  public UserManager(UserInteractionServiceInterface userInteractionService,
                     AddUserDetailsServiceInterface addUserDetails,
                     SortUserDetailsServiceInterface sortUserDetailsService,
                     DeleteUserDetailsServiceInterface deleteUserDetails) {
    this.users = new HashSet<>();
    this.userInteractionService = userInteractionService;
    this.commandMap = new HashMap<>();
    commandMap.put(1, new AddUserCommand(addUserDetails));
    commandMap.put(2, new SortUserCommand(sortUserDetailsService));
    commandMap.put(3, new DeleteUserCommand(deleteUserDetails));
  }

  @Override
  public void setTerminateProgram(boolean terminateProgram) {
    this.terminateProgram = terminateProgram;
  }

  @Override
  public void startManager() {
    while (!terminateProgram) {
      int userChoice = userInteractionService.displayMenuAndGetUserChoice();
      UserCommandInterface command = commandMap.get(userChoice);
      command.execute(users);
    }
  }
}
