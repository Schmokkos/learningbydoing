package no.schweizer;

import no.schweizer.controller.InputController;

import java.util.Scanner;

class CollatzSequence {
    private static Scanner scan = new Scanner(System.in);
    CollatzSequence(){
        System.out.println("Welcome to Collatz Sequence 1.0");
        System.out.println("Invented by Lothar Collatz in 1937. Google it for more info...");
        System.out.println("*************************");
        InputController ic = new InputController();
        int n;
        boolean play = true;
        String inputLetter;
        char letter;
        for (;play;){
        n = ic.simpleDigitInput("Please enter the number you would like to start the sequence with: ", 0,0,false);
        int ten = 0;
        int high = n;
        for (int i = 0;n != 1;i++){
            if (ten == 10){
                System.out.println();
                ten = 0;
            }
            System.out.printf("%-8d",n);
            if (n % 2 == 0){
                //even
                n = (n / 2);
            }
            else {
                //odd
                n = (n * 3 + 1);
            }
            if (n > high){
                high = n;
            }
            ten++;
            if (n == 1){
                if (ten == 10){
                    System.out.println();
                }
                System.out.printf("%-8d",n);
                System.out.println();
                System.out.println("Sequence completed after "+i+" steps. Highest number was: "+high);
            }
        }
        System.out.println("Try again? (y/n) ");
        inputLetter = scan.next().toUpperCase();
        letter = inputLetter.charAt(0);
        if (letter == 'N'){
            play = false;
        }
        }
        scan.close();
    }
}
