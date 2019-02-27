package no.schweizer;

import no.schweizer.controller.InputController;
import no.schweizer.controller.ResultatController;

import java.util.Random;

class NimGame {

//    private static String turn;

    NimGame(int players){

        InputController ic = new InputController();
        ResultatController rc = new ResultatController();
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
        int noofpiles = ic.simpleDigitInput("Enter the number of piles you want to play with, a normal game is 3 but you can play with as many as 5: ", 2, 5, false);
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
        String turn;
        if (rnum.nextBoolean()){
            turn = player1;
        }
        else turn = player2;
        System.out.println(turn+" goes first...");
        System.out.println();

        //Setting the needed variables to make moves
        char fromPile;
        int removeObjects;

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
            for (int i = 1; i <= max; max--){
                System.out.print("     ");
                switch (noofpiles){
                    case 2:
                        if (size[0] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[1] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        break;
                    case 3:
                        if (size[0] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[1] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[2] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        break;
                    case 4:
                        if (size[0] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[1] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[2] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[3] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        break;
                    case 5:
                        if (size[0] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[1] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[2] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[3] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                        if (size[4] >= max){
                            System.out.print("* ");
                        }
                        else System.out.print("  ");
                }
                System.out.println();
            }
            //Printing the names of the piles
            System.out.print("     ");
            for (char c:piles
                 ) {
                System.out.print(c+" ");
            }
            System.out.println();
            //TODO Here we should check if the player has won...

            //Getting next move from player

            //TODO Here is where the Computer player can do its move.

            //First which pile
            for (; ; ) {
                fromPile = ic.simpleCharInput(turn + "Select the pile you would like to remove objects from: ", true);
                //Checking if the defined letter is a valid pile
                if (rc.isLetterInWord(fromPile, piles)){
                    //Checking if there are any objects left in the pile
                    if (fromPile == 'A'){
                        if (size[0] == 0){
                            System.out.println("That pile is already empty...");
                            continue;
                        }
                        break;
                    }
                    if (fromPile == 'B'){
                        if (size[1] == 0){
                            System.out.println("That pile is already empty...");
                            continue;
                        }
                    }
                    if (fromPile == 'C'){
                        if (size[2] == 0){
                            System.out.println("That pile is already empty...");
                            continue;
                        }
                    }
                    if (fromPile == 'D'){
                        if (size[3] == 0){
                            System.out.println("That pile is already empty...");
                            continue;
                        }
                    }
                    if (fromPile == 'E'){
                        if (size[4] == 0){
                            System.out.println("That pile is already empty...");
                            continue;
                        }
                    }
                }
                System.out.println("That is not a valid pile.");
            }
            //Then how many object player wants to remove from piles

            //temp break to end loop for testing. To be removed
            break;
        }
    }
}
