package no.schweizer;

import java.util.Scanner;

public class AppSelector {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Please select what application you would like to launch");
        System.out.println("1 - MathTester");
        System.out.println("2 - HangMan");
        System.out.println("3 - Collatz Sequence");
        System.out.println("4 - NIM (Players vs Player)");
        System.out.println("5 - NIM (Player vs Computer)");
        System.out.println("6 - Box Stacker");
        System.out.println("Anything else - Exit");
        System.out.print("Input app number:");
        int input = 0;
        if (scan.hasNextInt()){
            input = scan.nextInt();
        }
        if (input == 1){
            new MathTester();
        }
        else if (input == 2){
            new HangMan();
        }
        else if (input == 3){
            new CollatzSequence();
        }
        else if (input == 4){
            new NimGame(2);
        }
        else if (input == 5){
            new NimGame(1);
        }
        else if (input == 6){
            new BoxStacker();
        }
        else {
            System.out.println("Bye...");
        }
    }
}
