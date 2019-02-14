package no.schweizer;

import java.util.Scanner;

public class AppSelector {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Please select what application you would like to launch");
        System.out.println("1 - MathTester");
        System.out.println("2 - HangMan");
        System.out.println("Anything else - Exit");
        System.out.print("Input app number:");
        int input = scan.nextInt();

        if (input == 1){
            new MathTester();
        }
        if (input == 2){
            new HangMan();
        }
        else {
            System.out.println("Bye then...");
        }
    }
}
