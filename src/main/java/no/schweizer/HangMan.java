package no.schweizer;

import no.schweizer.controller.InputController;
import no.schweizer.controller.QuestionController;
import no.schweizer.controller.ResultatController;

class HangMan {
    private static int wrongAnswers = 0;

    HangMan(){
        //Starting the InputController and showing welcome message
        InputController ic = new InputController();
        System.out.println("Welcome to Hang Man 1.1 :)");
        System.out.println("*******************");
        int wordLenght = Integer.parseInt(ic.simpleInput("Word or sentence? Enter 0 (zero) for sentence, or the length of the word you want (between 5-7): ", "Invalid input (Only the numbers 0, 5, 6 or 7 is allowed).", "^[05-7]$"));
        //Generating a word/sentence and turning it into arrays
        QuestionController qc = new QuestionController();
        char[] wordarray = qc.createWord(wordLenght).toUpperCase().toCharArray();
        boolean[] correctLetter = new boolean[wordarray.length];

        //This part sets spaces to true in correctLetter array and prints the word/sentence first time all blank.
        for (int i = 0;i < wordarray.length; i++){
            if (wordarray[i] == ' '){
                correctLetter[i] = true;
                System.out.print("   ");
            }
            System.out.print("_ ");
        }
        System.out.println();

        //This is where the actual guessing of the letters start
        ResultatController rc = new ResultatController();
        char letter;
        do {
            letter = ic.simpleInput("Guess your next letter: ", "Please only input a simgle letter (A-Å).", "(?i)^[A-ZÆØÅ]$").toUpperCase().charAt(0);
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
                    System.out.println("The correct word was: ");
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

        }while (!rc.isItSolved(correctLetter));
    }
}
