package org.example.prompt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class MenuPromptTest {

  @Test
  public void testShowMenu() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    MenuPrompt.showMenu();

    System.setOut(originalOut);
    String expectedOutput = "1.Add User details\n" + "2.Display User details\n"
        + "3.Delete User details\n" + "4.Save User details\n" + "5.Exit\n\n" + "Enter choice :  \n";

    String actualOutput = outputStream.toString().replace("\r\n", "\n").replace("\r", "\n").trim();
    expectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n").trim();

    assertEquals(expectedOutput, actualOutput);
  }
}
