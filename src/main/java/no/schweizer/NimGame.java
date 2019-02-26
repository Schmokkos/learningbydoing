package no.schweizer;

import no.schweizer.controller.InputController;

import java.util.Random;

class NimGame {

    private static String turn;

    NimGame(int players){

        InputController ic = new InputController();
        System.out.println("Welcome to NIM Game 1.0 :)");
        System.out.println("*******************");

        //Name the players
        String player1 = ic.simpleStringInput("Player 1, enter your name: ", false);
        String player2;
        if (players == 2){
            player2 = ic.simpleStringInput("Player 2, enter your name: ", false);
        }
        else {
            player2 = "Computer";
        }

        //Decide the number of piles
        int noofpiles = ic.simpleDigitInput("Enter the number of piles you want to play with, normalt is 3 but you can play with as many as 5: ", 2, 5, false);
        char[] piles = new char[noofpiles];
        byte[] size = new byte[noofpiles];
        switch (noofpiles){
            case 5:
                piles[4] = 'E';
                size[4] = 7;
            case 4:
                piles[3] = 'D';
                size[3] = 6;
            case 3:
                piles[2] = 'C';
                size[2] = 5;
            case 2:
                piles[1] = 'B';
                piles[0] = 'A';
                size[1] = 4;
                size[0] = 3;
                break;
                default: throw new IllegalArgumentException("Value difficulty was "+noofpiles+" expected int 2-5");
        }

        //Display the rules:
        System.out.println("______________________");
        System.out.println("The RULES of the game:");
        System.out.println("NIM is a mathematical game of strategy in which two players take turns removing objects from distinct piles.");
        System.out.println("On each turn, a player must remove at least one object, and may remove any number of objects provided they all come");
        System.out.println("from the same pile. The goal of the game is to avoid taking the last object. This is also known as a misère game.");
        System.out.println();
        System.out.println("Flipping a coin to see who goes first...");

        //Picking who goes first
        Random rnum = new Random();
        if (rnum.nextBoolean()){
            turn = player1;
        }
        else turn = player2;
        System.out.println(turn+" goes first...");

        //here goes...
        byte max;
        for (; ;){
            //Resetting "max" and then checking for and setting it to the biggest value in the "size" array.
            max = 0;
            for (byte nr:size
                 ) {
                    if (nr > max){
                        max = nr;
                    }
            }
            //Printing the current state of the piles
            for (int i = 0; i < max; i++){

            }
        }
    }
}
