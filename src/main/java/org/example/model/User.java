package org.example.model;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Comparable<User>, Serializable {
  private String name;
  private int age;
  private String address;
  private String rollNumber;
  private String[] enrolledCourses;

  public User(final String name, final String rollNumber, final int age, final String address,
              final String[] enrolledCourses) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.rollNumber = rollNumber;
    this.enrolledCourses = enrolledCourses;
  }

  public void display() {
    System.out.println(
        "User { name = '" + name + "', rollNumber = '" + rollNumber + "', age = " + age + ", "
            + "address = '" + address + "' enrolled courses = " + Arrays.toString(enrolledCourses)
            + " }");
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public String getRollNumber() {
    return rollNumber;
  }

  public String[] getEnrolledCourses() {
    return enrolledCourses;
  }

  @Override
  public int compareTo(final User a) {
    if (name.equals(a.name)) {
      return rollNumber.compareTo(a.rollNumber);
    }
    return name.compareTo(a.name);
  }
}
