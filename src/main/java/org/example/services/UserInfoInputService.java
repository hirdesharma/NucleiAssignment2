package org.example.services;

import java.util.Scanner;
import org.example.model.User;

public class UserInfoInputService {
  Scanner scanner = new Scanner(System.in);

  public User userInfoInputPrompt() {
    System.out.println("Enter New User Details\n");
    System.out.println("Enter Full Name");
    final String fullName = scanner.nextLine();

    System.out.println("Enter Age");
    final int age = Integer.parseInt(scanner.nextLine());

    System.out.println("Enter Address");
    final String address = scanner.nextLine();

    System.out.println("Enter rollNo");
    final String rollNo = scanner.nextLine();

    System.out.println("Enter Courses you want to enroll in, with a space between all courses");
    final String[] setOfCourses = (scanner.nextLine()).split(" ");

    return new User(fullName, rollNo, age, address, setOfCourses);
  }
}
