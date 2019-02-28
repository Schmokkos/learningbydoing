package no.schweizer;

import no.schweizer.classes.ArtificialIntelligence;
import no.schweizer.controller.InputController;
import no.schweizer.controller.ResultatController;

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

        //Setting the needed variables to make moves
        char fromPile;
        int objectsInPile;
        int removeFromPile;

        //here goes...
        int max;
        for (; ;){
            System.out.println();
            //Resetting "max" and then checking for and setting it to the biggest value in the "size" array.
            max = 0;
            for (int nr:size
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

            //Checking if a player has won or lost.
            if (rc.didThePlayerWin(size)){
                System.out.println("Player "+turn+" is the Winner!! :)");
                break;
            }
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
            if (turn.equals("Computer")){
                aichoice = ai.nimComputer(size);
                fromPile = piles[aichoice.get(0)];
                removeFromPile = aichoice.get(1);
                System.out.println("Computer removes "+removeFromPile+" objects from pile "+fromPile);
            }
            else {
                //Getting next move from player
                //First which pile
                for (; ; ) {
                    fromPile = ic.simpleCharInput(turn + "! Select the pile you would like to remove objects from: ", true);
                    //Checking if the defined letter is a valid pile
                    if (rc.isLetterInWord(fromPile, piles)) {
                        //Checking if there are any objects left in the pile
                        if (fromPile == 'A') {
                            if (size[0] == 0) {
                                System.out.println("That pile is already empty...");
                                continue;
                            }
                            objectsInPile = size[0];
                            break;
                        }
                        if (fromPile == 'B') {
                            if (size[1] == 0) {
                                System.out.println("That pile is already empty...");
                                continue;
                            }
                            objectsInPile = size[1];
                            break;
                        }
                        if (fromPile == 'C') {
                            if (size[2] == 0) {
                                System.out.println("That pile is already empty...");
                                continue;
                            }
                            objectsInPile = size[2];
                            break;
                        }
                        if (fromPile == 'D') {
                            if (size[3] == 0) {
                                System.out.println("That pile is already empty...");
                                continue;
                            }
                            objectsInPile = size[3];
                            break;
                        }
                        if (fromPile == 'E') {
                            if (size[4] == 0) {
                                System.out.println("That pile is already empty...");
                                continue;
                            }
                            objectsInPile = size[4];
                            break;
                        }
                    }
                    System.out.println("That is not a valid pile.");
                }
                //Then how many object player wants to remove from piles
                removeFromPile = ic.simpleDigitInput("How many objects would you like to remove from pile " + fromPile + ": ", 1, objectsInPile, false);
            }
            //Removing the objects from the pile
            if (fromPile == 'A'){
                size[0] = (size[0] - removeFromPile);
            }
            if (fromPile == 'B'){
                size[1] = (size[1] - removeFromPile);
            }
            if (fromPile == 'C'){
                size[2] = (size[2] - removeFromPile);
            }
            if (fromPile == 'D'){
                size[3] = (size[3] - removeFromPile);
            }
            if (fromPile == 'E'){
                size[4] = (size[4] - removeFromPile);
            }

            //Switching to the next players turn
            if (turn.equals(player1)){
                turn = player2;
            }
            else turn = player1;
        }
    }
}
