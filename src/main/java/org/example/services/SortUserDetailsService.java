package org.example.services;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;

public class SortUserDetailsService implements SortUserDetailsServiceInterface {

  private final UserInputChoiceService userInputChoiceService;
  private final UserInputOrderService userInputOrderPrompt;
  private final Map<Integer, Comparator<User>> comparatorMap;

  public SortUserDetailsService(UserInputChoiceService userInputChoiceService,
                                UserInputOrderService userInputOrderPrompt) {
    this.userInputChoiceService = userInputChoiceService;
    this.userInputOrderPrompt = userInputOrderPrompt;
    this.comparatorMap = Map.of(11, Comparator.comparing(User::getName),
        21, Comparator.comparing(User::getName).reversed(),
        12, Comparator.comparing(User::getRollNumber),
        22, Comparator.comparing(User::getRollNumber).reversed(),
        13, Comparator.comparingInt(User::getAge),
        23, Comparator.comparingInt(User::getAge).reversed(),
        14, Comparator.comparing(User::getAddress),
        24, Comparator.comparing(User::getAddress).reversed());
  }

  public void sortUserDetails(final Set<User> users) {
    try {
      int choice = userInputChoiceService.userInputChoice();
      int order = userInputOrderPrompt.userInputOrder();
      // modifying choice to get desired sorting without any conditional statements;
      choice = choice + 10 * order;

      Comparator<User> comparator = comparatorMap.get(choice);

      comparator = (order == 2) ? comparator.reversed() : comparator;

      users.stream().sorted(comparator).forEach(user -> user.display());
    } catch (Exception e) {
      throw new InvalidArgument("error : " + e.getMessage());
    }
  }

}
