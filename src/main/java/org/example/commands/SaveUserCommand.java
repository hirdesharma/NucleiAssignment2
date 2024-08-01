package org.example.commands;

import java.util.Set;
import org.example.discstorage.StorageHandler;
import org.example.model.User;

public class SaveUserCommand implements UserCommandInterface {
  private final StorageHandler storageHandler;

  public SaveUserCommand(StorageHandler storageHandler) {
    this.storageHandler = storageHandler;
  }

  @Override
  public void execute(final Set<User> users) {
    storageHandler.saveUsersToDisc(users);
  }
}