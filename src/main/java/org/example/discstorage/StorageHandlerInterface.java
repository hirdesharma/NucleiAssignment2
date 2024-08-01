package org.example.discstorage;

import java.util.Set;
import org.example.model.User;

public interface StorageHandlerInterface {
  void saveUsersToDisc(Set<User> user);

  Set<User> getUsersFromDisk();
}
