import java.util.*;

public class Player
{
  // colors
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
  public static final String BLACKBG = "\u001B[40m";
  public static final String WHITEBG = "\u001B[47m";
  // instance variables
  private String name;
  private int number;
  private String token;
  // constructor for player objects
  public Player(String n, int num, String sign)
  {
    name = n;
    number = num;
    token = sign;
  }
  
  // find the lowest avaiable space in in a column, if column is full, returns null
  public java.lang.Integer getAvailable(int s)
  {
    for (int i = 5; i >= 0; i--)
    {
      if (Main.systemBoard[i][s-1] == 0) 
      {
        return i;
      } 
      
    }
    return null;
  }
  // accesor methods
  public String getName()
  {
    return name;
  }
  
  public String getToken()
  {
    return token;
  }
  // player turn method
  public void takeTurn()
  {
    int placement = 8;
    Scanner input = new Scanner(System.in);
    while (placement > 7 || placement < 1) 
    {
      Game.printText(BLUE + "\n" + getName() + ", select which position you want to place your disk. (1-7 left to right)\n\n" + RESET, 1);
      try 
      {
        placement = input.nextInt();
      }
      catch (Exception e)
      {
        System.out.println(RED + "\nInvalid Input\n" + RESET);
        input.nextLine();
      }
    }
    for (int i = 0; i <= 1; i++)
    {
      if (getAvailable(placement) != null)
      {
        Main.board[getAvailable(placement)][placement-1] = token;
        Main.systemBoard [getAvailable(placement)][placement-1] = number;
        i=1;
      }
      else
      {
        Game.printText("This column is full, please place your token in a different column\n", 1);
        placement = input.nextInt();
        i = 0;
      }
    }
  }
}
