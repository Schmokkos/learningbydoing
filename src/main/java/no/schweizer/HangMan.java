package no.schweizer;

import no.schweizer.controller.QuestionController;
import no.schweizer.controller.ResultatController;

import java.util.Scanner;

class HangMan {
    private static int wrongAnswers = 0;
//    private static boolean solvedWord;
//    private static boolean youDied;
    private static Scanner scan = new Scanner(System.in);
    HangMan(){
        System.out.println("Welcome to Hang Man 1.0 :)");
        System.out.println("*******************");
        System.out.print("Enter the length of the word you want (between 5-7): ");
        int wordLenght = scan.nextInt();

        for (;wordLenght<5 || wordLenght>7;){
            System.out.print("The length has to be between 5 and 7 letters. Try again:");
            wordLenght = scan.nextInt();
        }

        QuestionController qc = new QuestionController();
        char[] wordarray = qc.createWord(wordLenght).toCharArray();
        boolean[] correctLetter = new boolean[wordarray.length];

        for (int i = 0;i < wordarray.length; i++){
            System.out.print("_ ");
        }
        System.out.println();
        System.out.print("Guess your first letter: ");

        ResultatController rc = new ResultatController();
        String inputLetter;
        char letter;
        do {
            inputLetter = scan.next();
            letter = inputLetter.charAt(0);
            System.out.println();

            if (rc.isLetterInWord(letter,wordarray)){

                for (int i = 0; i<wordarray.length;i++){
                    if (letter == wordarray[i]) correctLetter[i] = true;
                }
                if (rc.isItSolved(correctLetter)){
                    for (char l:wordarray){
                        System.out.print(l);
                    }
                    System.out.println();
                    System.out.println("You won! Congratulation :)");
                    break;
                }
                System.out.println("Correct, letter "+letter+" is in the word!");
            }
            else {
                wrongAnswers++;
                if (rc.areYouDead(wrongAnswers,10)){
                    System.out.println("You guessed wrong too many times and were hung :(");
                    System.out.print("The correct word was: ");
                    for (char l:wordarray){
                        System.out.print(l);
                    }
                    break;
                }
                System.out.println("Letter not in word. Number of incorrect guesses so far: "+wrongAnswers+"/10");
            }

            for (int i = 0; i<wordarray.length; i++){
                if (correctLetter[i]) System.out.print(wordarray[i]+" ");
                else System.out.print("_ ");
            }
            System.out.println();
            System.out.print("Guess the next letter: ");

        }while (!rc.isItSolved(correctLetter));

        scan.close();
    }
}
