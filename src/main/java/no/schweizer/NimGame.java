package no.schweizer;

import no.schweizer.classes.ArtificialIntelligence;
import no.schweizer.controller.InputController;
import no.schweizer.controller.ResultatController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class NimGame {

    NimGame(int players){

        InputController ic = new InputController();
        ResultatController rc = new ResultatController();
        ArtificialIntelligence ai = new ArtificialIntelligence();
        System.out.println("Welcome to NIM Game 1.0 :)");
        System.out.println("*******************");

        //Name the players
        final String player1 = ic.simpleInput("Player 1, enter your name: ", "Invalid input (Only a name containing lettes allowed).", "(?i)^[A-ZÆØÅ]+$");
        final String player2;
        if (players == 2){
            player2 = ic.simpleInput("Player 2, enter your name: ", "Invalid input (Only a name containing lettes allowed).", "(?i)^[A-ZÆØÅ]+$");
        }
        else {
            player2 = "Computer";
        }

        //Decide the number of piles
        final int noofpiles = Integer.parseInt(ic.simpleInput("Enter the number of piles you want to play with, a normal game is 3 but you can play with as many as 5: ", "Invalid input (Only a number between 2 and 5 is allowed).", "^[2-5]$"));
        char[] piles = new char[noofpiles];
        int[] size = new int[noofpiles];
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
                default: throw new IllegalArgumentException("Value noofpiles was "+noofpiles+" expected int 2-5");
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

        //Setting the needed variables to make moves
        char fromPile;
        int objectsInPile;
        StringBuilder pilesWithObjects = new StringBuilder();
        int removeFromPile;
        int fromPileLetterIndex;

        //here goes...
        int max;
        do {
            System.out.println();
            //Resetting "max" and setting it to the biggest value in the "size" array. This limits the height of the method that prints the current state
            max = 0;
            for (int nr:size
                 ) {
                    if (nr > max){
                        max = nr;
                    }
            }
            //Checking if the player has won before printing the state.
            if (rc.didThePlayerWin(size)){
                System.out.println("The last object was removed, Player "+turn+" is the Winner!! :)");
                break;
            }
            //Printing the current state of the piles
            for (int i = 1; i <= max; max--){
                System.out.print("     ");
                for (int pile:size
                     ) {
                    if (pile >= max){
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

            //Checking if a player has to remove the last object and thus lost.
            if (rc.didThePlayerLoose(size)){
                String winner;
                if (turn.equals(player1)){
                    winner = player2;
                }
                else{
                    winner = player1;
                }
                System.out.println(turn+", you have to take the remaining object, so you lose!");
                System.out.println(winner+" is the Winner!! :)");
                break;
            }
            //Checking if player 2 is a computer and if so getting the AI to decide what to do
            List<Integer> aichoice;
            if (turn.equals("Computer") && players == 1){
                aichoice = ai.nimComputer(size);
                fromPile = piles[aichoice.get(0)];
                removeFromPile = aichoice.get(1);
                System.out.println("Computer removes "+removeFromPile+" objects from pile "+fromPile);
                fromPileLetterIndex = Arrays.binarySearch(piles, fromPile);
            }
            else {
                //Getting next move from player
                //First checking which piles have objects in them and storing them in pilesWithObjects.
                pilesWithObjects.setLength(0);
                for (int i = 0; i <= size.length-1; i++){
                    if (size[i] != 0){
                        pilesWithObjects.append(piles[i]);
                    }
                }
                //Then get the pile from the player that the player wants to remove objects from and setting objectsInPile to how many objects are left in the pile
                fromPile = ic.simpleInput(turn + "! Select the pile you would like to remove objects from: ", "Invalid input (Enter a single letter representing an existing pile ("+pilesWithObjects+")).", "(?i)^["+pilesWithObjects+"]$").toUpperCase().charAt(0);
                fromPileLetterIndex = Arrays.binarySearch(piles, fromPile);
                objectsInPile = size[fromPileLetterIndex];
                //Then how many object player wants to remove from that pile
                removeFromPile = Integer.parseInt(ic.simpleInput("How many objects would you like to remove from pile " + fromPile + ": ", "Invalid input (There are only "+objectsInPile+" objects left).", "^[1-"+objectsInPile+"]$"));
            }
            //Removing the objects from the pile
            if (fromPileLetterIndex == -1){
                throw new IllegalStateException("Could not find the letter "+fromPile+" in the piles-array.");
            }
            else {
                size[fromPileLetterIndex] -= removeFromPile;
            }

            //Switching to the next players turn
            if (turn.equals(player1)){
                turn = player2;
            }
            else turn = player1;
        }
        while (true);
    }
}
