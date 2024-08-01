package org.example.commands;

import java.util.Scanner;
import java.util.Set;
import org.example.model.User;
import org.example.services.UserManagerInterface;

public class ProgramTerminateCommand implements UserCommandInterface {

  private final SaveUserCommand saveUserCommand;
  private final UserManagerInterface userManager;

  public ProgramTerminateCommand(SaveUserCommand saveUserCommand,
                                 UserManagerInterface userManager) {
    this.saveUserCommand = saveUserCommand;
    this.userManager = userManager;
  }

  @Override
  public void execute(final Set<User> users) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do You Want To Save Changes Into The Disk ?\n 1 : Yes \n 2 : No");
    int userResponse = scanner.nextInt();

    if (userResponse == 1) {
      saveUserCommand.execute(users);
    }
    userManager.setTerminateProgram(true);
  }
}
