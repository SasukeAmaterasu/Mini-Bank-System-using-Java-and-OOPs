package MiniBank;

import java.util.Scanner;

public class Feedback{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please provide your feedback about our banking services:");
    String feedback = sc.nextLine();
    sc.close();
  }
}