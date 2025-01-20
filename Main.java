import java.util.Scanner;



public class Main 
{
  // colors
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = 	"\u001B[31m";
  public static final String GREEN = 	"\u001B[32m";
  public static final String YELLOW = 	"\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
  public static final String BLACKBG = "\u001B[40m";
  public static final String WHITEBG = "\u001B[47m";
  // board 2d array
  static String [][] board = {{"-","-","-","-","-","-","-"},
                              {"-","-","-","-","-","-","-"},
                              {"-","-","-","-","-","-","-"},
                              {"-","-","-","-","-","-","-"},
                              {"-","-","-","-","-","-","-"},
                              {"-","-","-","-","-","-","-"}};
  static int [][] systemBoard = {{0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0}};

  // used to print name for winner
  static String currentPlayer = "";
  
  public static void main(String[] args) 
  {
    // parameters for object
    String name1 = "";
    String name2 = "";
    String marker1 = "";
    String marker2 = "";
    //type writer effect
    Game.printText(CYAN + "\nWelcome to Connect 4!", 20);
    Game.printText("\n\nThere are 3 game modes you can choose from:", 15);
    Game.printText("\nClassic, Custom, and Ultimate.", 15);
    Game.printText("\n\nClassic:\nNormal rules, first to get 4 in a row wins!", 20);
    Game.printText("\n\nCustom:\nNormal rules but players get to select their markers for their positions. First to get 4 in a row wins!", 20);
    Game.printText("\n\nUltimate:\nNormal rules. However, both players are given the same indistinguishable marker. ", 20);
    Game.printText("First to get 4 in a row wins. Let the player with the best memory win!\n\n" + RESET, 20);
    // user choice
    int response = 0;
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
      
    while (response < 1 || response > 3) 
    {
      Game.printText(CYAN + "Select which game mode you would like to play:\n\nClassic(1)\nCustom(2)\nUltimate(3)\n\n" + RESET, 20);
      try
      {
        response = input.nextInt();
      }
      catch (Exception e)
      {
        System.out.println(RED + "Invalid Input\n" + RESET);
        input.nextLine();
      }
    }
    // different game modes
    if (response == 1) 
    {
      Game.printText(RED + "\nWhat is the name of Player 1?\n\n" + RESET, 20);
      name1 = input2.nextLine();
      marker1 = "X";
        
      Game.printText(RED + "\nWhat is the name of Player 2?\n\n" + RESET, 20);
      name2 = input2.nextLine();
      marker2 = "O";
    }
      
    if (response == 2) 
    {
      Game.printText(RED + "\nWhat is the name of Player 1?\n\n" + RESET, 20);
      name1 = input2.nextLine();
        
      int markerLen = 2;
      while (markerLen != 1) {
        Game.printText(RED + "\nWhat marker would you like " + name1 + "?(Must be one character)\n\n" + RESET, 20);
        marker1 = input2.nextLine();
        markerLen = marker1.length();
      }
      
      Game.printText(RED + "\nWhat is the name of Player 2?\n\n" + RESET, 20);
      name2 = input2.nextLine();
      markerLen = 2;
        
      while (markerLen != 1) {
        Game.printText(RED + "\nWhat marker would you like " + name2 + "?(Must be one character)\n\n" + RESET, 20);
        marker2 = input2.nextLine();
        markerLen = marker2.length();
      }
    }
      
    if (response == 3) 
    {
      Game.printText(RED + "\nWhat is the name of Player 1?\n\n" + RESET, 20);
      name1 = input2.nextLine();
      marker1 = PURPLE + "O" + RESET;
        
      Game.printText(RED + "\nWhat is the name of Player 2?\n\n" + RESET, 20);
      name2 = input2.nextLine();
      marker2 = PURPLE + "O" + RESET;
    }

    // initialize objects with parameters based on game mode selection
    Player p1 = new Player(name1, 1, marker1);
    Player p2 = new Player(name2, 2, marker2);

    // run game
    while (!Game.isGameOver()) 
    {
      Game.printBoard();
      p1.takeTurn();
      currentPlayer = p1.getName();
      Game.check();
      if (!Game.isGameOver())
      {
        Game.printBoard();
        p2.takeTurn();
        currentPlayer = p2.getName();
        Game.check();
      }
    }
    
    Game.printBoard();
    
    System.out.println("\n\nPress any key to exit...");
    new Scanner(System.in).nextLine(); // Wait for user input
  }
}