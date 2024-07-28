package org.example;

import org.example.commands.SaveUserCommand;
import org.example.discstorage.UserInfoDiscStorageHandler;
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
      UserInteractionServiceValidator userInteractionServiceValidator =
          new UserInteractionServiceValidator();
      UserInteractionServiceInterface userInteractionService = new UserInteractionService();
      AddUserDetailsServiceInterface addUserDetailsService = new AddUserDetailsService();
      UserInputChoiceService userInputChoiceService = new UserInputChoiceService();
      UserInputOrderService userInputOrderPrompt = new UserInputOrderService();
      DeleteUserDetailsServiceInterface deleteUserDetails = new DeleteUserDetailsService();
      UserInfoDiscStorageHandler userInfoDiscStorageHandler = new UserInfoDiscStorageHandler();
      SortUserDetailsServiceInterface sortUserDetailsService =
          new SortUserDetailsService(userInputChoiceService, userInputOrderPrompt);
      SaveUserCommand saveUserCommand = new SaveUserCommand(userInfoDiscStorageHandler);

      UserManager userManager = new UserManager(userInteractionService,
          addUserDetailsService, sortUserDetailsService, deleteUserDetails,
          userInfoDiscStorageHandler, saveUserCommand);

      userManager.startManager();
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    }
  }
}