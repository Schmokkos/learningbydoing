package no.schweizer.controller;

import java.util.Scanner;

public class InputController {

    public int simpleDigitInput(String text, int lowlimit, int highlimit, boolean allowzero) {

        Scanner scan = new Scanner(System.in);

        for (; ; ) {
            System.out.print(text);
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input (Only numbers allowed).");
                scan.next();
                continue;
            }
            int number = scan.nextInt();
            if (!allowzero && number == 0){
                System.out.println("Invalid input (Zero not allowed).");
                continue;
            }
            if (allowzero && number == 0){
                return number;
            }
            if (lowlimit == 0 && highlimit == 0) {
                return number;
            }
            if (number <= highlimit && number >= lowlimit) {
                return number;
            }
            else {
                System.out.println("Only a number between " + lowlimit + " and " + highlimit + " is allowed");
            }

        }
    }

    public char simpleCharInput(String text, boolean onlyuppercase){

        Scanner scan = new Scanner(System.in);
        char input;

        for (; ; ){
            System.out.print(text);
            if (onlyuppercase){
                input = scan.next().toUpperCase().charAt(0);
            }
            else {
                input = scan.next().charAt(0);
            }
            if (!Character.isLetter(input)){
                System.out.println("Invalid input (Only letters allowed).");
            }
            else {
                return input;
            }
        }
    }
}
