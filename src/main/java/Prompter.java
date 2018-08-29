import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Prompter {
  private BufferedReader reader;
  
  public Prompter() {
    reader = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public Jar promptAdminForJarParameters() {
    String itemName = promptForInput("What type of item? ");
    int maximumItems = promptForInputExpectingInteger("What is the maximum amount of " + itemName + "? ");

    return new Jar(itemName, maximumItems);
  }
  
  public void promptPlayerForGuess(int answer, int maximumGuess) {
    int numberOfGuesses = 0;
    int response = 0;
    while (response != answer) {
      response = promptForInputExpectingInteger("Guess: ");
      if (response > maximumGuess) {
        System.out.printf("Your guess must be less than %d. %n",
                          maximumGuess);
      } else {
        if (response > answer) {
          System.out.printf("HINT: your guess was too high. %n");
        } else if (response < answer) {
          System.out.printf("HINT: your guess was too low. %n");
        }
        numberOfGuesses++;
      }
    }
    
    if (numberOfGuesses == 1) {
      System.out.printf("You did it! You won after %d attempt. %n",
                        numberOfGuesses);
    } else {
      System.out.printf("You won in %d attempts. %n",
                      numberOfGuesses);
    }
  }
  
  private String promptForInput(String message) {
    String response = "";
    while (response.isEmpty()) {
      try {
        System.out.print(message);
        response = reader.readLine();
      } catch (IOException e) {
        System.out.printf("It looks like there was an issue handling your input. The message was: %s",
                          e.getMessage());
        System.out.print("Please try again. ");
      }
    }
    return response;
  }
  
  private int promptForInputExpectingInteger(String message) {
    int response = 0;
    while (response <= 0) {
      try {
        response = Integer.parseInt(promptForInput(message));
        if (response <= 0) {
          throw new NumberFormatException();
        }
      } catch (NumberFormatException e) {
        System.out.printf("The value you provided was not a non-zero number. Please try again. %n");
      }
    }
    return response;
  }
}