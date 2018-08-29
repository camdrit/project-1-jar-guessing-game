public class GuessingGame {
  
    public static void main(String[] args) {
      System.out.printf("ADMINISTRATOR SETUP %n=======================%n");
      
      Prompter prompter = new Prompter();
      Jar jar = prompter.promptAdminForJarParameters();
      jar.fill();
      
      System.out.printf("PLAYER  %n=======================%n");
      System.out.printf("How many %s are in the jar? Pick a number between 1 and %d. %n%n",
                        jar.getItemName(), jar.getMaximumItems());
      
      prompter.promptPlayerForGuess(jar.getNumberOfItems(), jar.getMaximumItems());
      
    }
  
    
}
