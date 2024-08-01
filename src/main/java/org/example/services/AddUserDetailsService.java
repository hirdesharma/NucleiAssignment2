package org.example.services;

import org.example.exceptions.InvalidArgument;
import org.example.model.User;
import org.example.validators.UserDetailValidator;

public class AddUserDetailsService implements AddUserDetailsServiceInterface {

  @Override
  public User addUser() {
    try {
      UserInfoInputService userInfoInputService = new UserInfoInputService();
      User user = userInfoInputService.createNewUser();

      UserDetailValidator userDetailValidator = new UserDetailValidator(
          user.getName(), user.getAge(), user.getAddress(),
          user.getRollNumber(), user.getEnrolledCourses()
      );
      userDetailValidator.validate();

      return user;
    } catch (Exception e) {
      throw new InvalidArgument("Error : " + e.getMessage());
    }
  }
}
