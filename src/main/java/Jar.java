import java.util.Random;

public class Jar {
  private String itemName;
  private int maximumItems;
  private int numberOfItems;
 
  public Jar(String itemName, int maximumItems) {
    this.itemName = itemName;
    this.maximumItems = maximumItems;
  }
  
  public String getItemName() {
    return itemName;
  }
  
  public int getMaximumItems() {
   return maximumItems; 
  }
  
  public int getNumberOfItems() {
    return numberOfItems;
  }
  
  public void fill() {
    Random random = new Random();
    numberOfItems = random.nextInt(maximumItems) + 1;
  }
}