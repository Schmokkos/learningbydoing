package no.schweizer;

import no.schweizer.controller.ResultatController;

import java.util.Scanner;
import java.util.Random;

public class MathTester {
    private static int correctAnswers = 0;
    private static int numberOfQuestions;

    static Random rnum = new Random();
    static Scanner scan = new Scanner(System.in);

    private static void question(){
        int num1 = rnum.nextInt(20);
        int num2 = rnum.nextInt(20);

        System.out.println("What is: "+num1+"+"+num2+" ?");
        int result1 = scan.nextInt();

        if (result1 == num1+num2){
            System.out.println("Correct!");
            correctAnswers++;
        }
        else {
            System.out.println("Wrong! Correct answer was: "+(num1+num2));
        }
    }

    public static void main(String[] args){

        System.out.println("Welcome to Math Tester 1.0 :)");
        System.out.println("*******************");
        System.out.print("Enter the number of questions you want: ");
        numberOfQuestions = scan.nextInt();

        int i;
        for (i = 1; i <= numberOfQuestions; i++){
            MathTester.question();
        }

        // Closing Scanner after the use
        scan.close();

        System.out.println("----------------------");
        System.out.println("Correct answers: "+correctAnswers+"/"+numberOfQuestions);
        ResultatController rc = new ResultatController();
        System.out.print(rc.prosentResultat(correctAnswers, numberOfQuestions));
    }
}