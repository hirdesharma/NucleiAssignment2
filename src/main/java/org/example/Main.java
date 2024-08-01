package org.example;

import org.example.commands.SaveUserCommand;
import org.example.discstorage.StorageHandler;
import org.example.services.AddUserDetailsService;
import org.example.services.AddUserDetailsServiceInterface;
import org.example.services.DeleteUserDetailsService;
import org.example.services.DeleteUserDetailsServiceInterface;
import org.example.services.SortUserDetailsService;
import org.example.services.SortUserDetailsServiceInterface;
import org.example.services.UserInputChoiceService;
import org.example.services.UserInputOrderService;
import org.example.services.UserInteractionService;
import org.example.services.UserInteractionServiceInterface;
import org.example.services.UserManager;
import org.example.validators.UserInteractionServiceValidator;

public class Main {
  public static void main(String[] args) {
    try {
      UserManager userManager = createUserManager();
      userManager.startManager();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  static UserManager createUserManager() {
    UserInteractionServiceValidator serviceValidator =
        new UserInteractionServiceValidator();
    UserInteractionServiceInterface userInteractionService = new UserInteractionService();
    AddUserDetailsServiceInterface addUserDetailsService = new AddUserDetailsService();
    UserInputChoiceService userInputChoiceService = new UserInputChoiceService();
    UserInputOrderService userInputOrderPrompt = new UserInputOrderService();
    DeleteUserDetailsServiceInterface deleteUserDetails = new DeleteUserDetailsService();
    StorageHandler storageHandler = new StorageHandler();
    SortUserDetailsServiceInterface sortUserDetailsService =
        new SortUserDetailsService(userInputChoiceService, userInputOrderPrompt);
    SaveUserCommand saveUserCommand = new SaveUserCommand(storageHandler);

    return new UserManager(userInteractionService,
        addUserDetailsService, sortUserDetailsService, deleteUserDetails,
        storageHandler, saveUserCommand);
  }
}
