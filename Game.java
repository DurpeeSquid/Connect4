import java.util.*;
import java.lang.Thread;
public class Game
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
  
  private static boolean gameOver = false;

  // access gameOver on main method
  public static boolean isGameOver() 
  {
    return gameOver;
  }
  // delay text by a set amount
  public static void delayedText(String str, int speed) {
    try
    {
      Thread.sleep(speed);
      System.out.println(str);
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  // delay text so it appears to be typed out
  public static void printText(String str, int speed) {
    char [] arr = str.toCharArray();
    try {
      for (int i = 0; i < arr.length; i++) 
      {   
        System.out.print(arr[i]);
        Thread.sleep(speed);
      }
      //System.out.println("");
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  // print board method for game board
  public static void printBoard() 
  {
    System.out.println("");
    for (int r = 0; r < Main.board.length; r++) 
    {
      for (int c = 0; c < Main.board[0].length; c++) 
      {
        System.out.print(Main.board[r][c] + " ");
      }
      System.out.println(" ");
    }
    //System.out.println("1 2 3 4 5 6 7");
  }

  // check if the game is finished or not
  public static void check() {
    // check for a horizontal win
    for (int row = 0; row < Main.board.length; row++) 
    {
      for (int col = 0; col <= Main.board[row].length - 4; col++) 
      {
        if (Main.systemBoard[row][col] != 0 && Main.systemBoard[row][col] == Main.systemBoard[row][col + 1] && Main.systemBoard[row][col] == Main.systemBoard[row][col + 2] && Main.systemBoard[row][col] == Main.systemBoard[row][col + 3]) 
        {
          System.out.println(PURPLE + "\n" + Main.currentPlayer + " wins!\n" + RESET);
          gameOver = true;
        }
      }
    }

    // check for a vertical win
    for (int col = 0; col < Main.board[0].length; col++) 
    {
      for (int row = 0; row <= Main.board.length - 4; row++) 
      {
        if (Main.systemBoard[row][col] != 0 && Main.systemBoard[row][col] == Main.systemBoard[row + 1][col] && Main.systemBoard[row][col] == Main.systemBoard[row + 2][col] && Main.systemBoard[row][col] == Main.systemBoard[row + 3][col]) 
        {
          System.out.println(PURPLE + "\n" + Main.currentPlayer + " wins!\n" + RESET);
          gameOver = true;
        }
      }
    }

    // check for a diagonal win
    for (int row = 0; row <= Main.board.length - 4; row++) 
    {
      for (int col = 0; col <= Main.board[row].length - 4; col++) 
      {
        if (Main.systemBoard[row][col] != 0 && Main.systemBoard[row][col] == Main.systemBoard[row + 1][col + 1] && Main.systemBoard[row][col] == Main.systemBoard[row + 2][col + 2] && Main.systemBoard[row][col] == Main.systemBoard[row + 3][col + 3]) 
        {
          System.out.println(PURPLE + "\n " + Main.currentPlayer + " wins!\n" + RESET);
          gameOver = true;
        }
      }
    }

    // check for a diagonal win 2
    for (int row = 0; row <= Main.board.length - 4; row++) 
    {
      for (int col = 3; col < Main.board[row].length; col++) 
      {
        if (Main.systemBoard[row][col] != 0 && Main.systemBoard[row][col] == Main.systemBoard[row + 1][col - 1] && Main.systemBoard[row][col] == Main.systemBoard[row + 2][col - 2] && Main.systemBoard[row][col] == Main.systemBoard[row + 3][col - 3]) 
        {
          System.out.println(PURPLE + "\n " + Main.currentPlayer + " wins!\n" + RESET);
          gameOver = true;
        }
      }
    }

    // check for a draw
    boolean isBoardFull = true;
    for (int row = 0; row < Main.board.length; row++) 
    {
      for (int col = 0; col < Main.board[row].length; col++) 
      {
        if (Main.systemBoard[row][col] == 0) 
        {
          isBoardFull = false;
          break;
        }
      }
      if (!isBoardFull) 
      {
        break;
      }
    }
    if (isBoardFull) 
    {
      System.out.println(PURPLE + "\nIt's a draw!\n" + RESET);
      gameOver = true;
    }
    
  }
}