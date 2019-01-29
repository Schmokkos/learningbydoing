package no.schweizer.controller;

import java.util.Random;
import java.util.Scanner;

public class QuestionController {

    public boolean questionCreator(int difficulty){
        Random rnum = new Random();
        Scanner scan = new Scanner(System.in);
        int num1 = rnum.nextInt(difficulty);
        int num2 = rnum.nextInt(difficulty);

        System.out.println("What is: "+num1+"+"+num2+" ?");
        int result1 = scan.nextInt();

        if (result1 == num1+num2){
            System.out.println("Correct!");
            return true;
        }
        else {
            System.out.println("Wrong! Correct answer was: "+(num1+num2));
            return false;
        }
    }
}
