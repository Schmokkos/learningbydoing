package no.schweizer;

import no.schweizer.controller.QuestionController;

import java.util.Scanner;

class HangMan {
    private static int wrongAnswers = 0;
    private static Scanner scan = new Scanner(System.in);
    HangMan(){
        System.out.println("Welcome to Hang Man 1.0 :)");
        System.out.println("*******************");
        System.out.print("Enter the length of the word you want (between 5-7): ");
        int wordLenght = scan.nextInt();

        QuestionController qc = new QuestionController();

        for (;wordLenght<5 || wordLenght>7;){
            System.out.print("The length has to be between 5 and 7 letters. Try again:");
            wordLenght = scan.nextInt();
        }

        char[] wordarray = qc.createWord(wordLenght).toCharArray();
        boolean[] correctLetter;

    }
}
