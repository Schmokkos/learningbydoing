package no.schweizer;

import no.schweizer.controller.QuestionController;
import no.schweizer.controller.ResultatController;

import java.util.Scanner;

public class MathTester {
    private static int correctAnswers = 0;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Welcome to Math Tester 1.0 :)");
        System.out.println("*******************");
        System.out.print("Enter the number of questions you want: ");
        int numberOfQuestions = scan.nextInt();
        int difficulty = 20;
        boolean result;
        QuestionController qc = new QuestionController();
        int i;
        for (i = 1; i <= numberOfQuestions; i++){
            result = qc.questionCreator(difficulty);
            if (result){
                correctAnswers++;
            }
        }
        // Closing Scanner after the use
        scan.close();

        System.out.println("----------------------");
        System.out.println("Correct answers: "+correctAnswers+"/"+numberOfQuestions);
        ResultatController rc = new ResultatController();
        System.out.print(rc.prosentResultat(correctAnswers, numberOfQuestions));
    }
}