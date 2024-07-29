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
    this.comparatorMap = Map.of(1, (a, b) -> a.getName().compareTo(b.getName()), 2,
        (a, b) -> a.getRollNumber().compareTo(b.getRollNumber()), 3,
        (a, b) -> Integer.compare(a.getAge(), b.getAge()), 4,
        (a, b) -> a.getAddress().compareTo(b.getAddress()));
  }

  public void sortUserDetails(final Set<User> users) {
    try{
      int choice = userInputChoiceService.userInputChoice();
      int order = userInputOrderPrompt.userInputOrder();

      Comparator<User> comparator = comparatorMap.get(choice);

      comparator = (order == 2) ? comparator.reversed() : comparator;

      users.stream().sorted(comparator).forEach(user -> user.display());
    }catch (Exception e){
      throw new InvalidArgument("error : " + e.getMessage());
    }
  }

}
