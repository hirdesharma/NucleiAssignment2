package org.example.discstorage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;

public class UserInfoDiscStorageHandler implements StorageHandlerInterface {
  public void saveUserInfoToDiscStorage(Set<User> user) {
    String filename = "userInfo.ser";
    try {
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);
      out.writeObject(user);
      out.close();
      file.close();
      System.out.println("User Info Saved to the Disk Storage");
    } catch (Exception e) {
      System.out.println("Information wasn't save successfully");
    }
  }

  public Set<User> getUsersFromDisk() {
    Set<User> users = new TreeSet<>();
    String filename = "userInfo.ser";
    try {
      FileInputStream file = new FileInputStream(filename);
      ObjectInputStream objectInputStream = new ObjectInputStream(file);
      users = (Set<User>) objectInputStream.readObject();
    } catch (Exception e) {
      throw new InvalidArgument("Couldn't fetch Users data from disk Error : " + e.getMessage());
    }
    return users;
  }
}
