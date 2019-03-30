package no.schweizer;

import no.schweizer.controller.InputController;
import no.schweizer.controller.QuestionController;
import no.schweizer.controller.ResultatController;

import java.text.DecimalFormat;
import java.util.Scanner;

class MathTester {
    private static int correctAnswers = 0;
    private static Scanner scan = new Scanner(System.in);

    MathTester(){

        InputController ic = new InputController();

        System.out.println("Welcome to Math Tester 1.0 :)");
        System.out.println("*******************");
        int numberOfQuestions = Integer.parseInt(ic.simpleInput("Enter the number of questions you want: ","Invalid input (Only a number is allowed).", "^[0-9]+$"));
        int difficulty = Integer.parseInt(ic.simpleInput("Enter the desired difficulty: ","Invalid input (Only a number between 1 and 5 is allowed).", "^[1-5]$"));

        boolean result;
        QuestionController qc = new QuestionController();
        for (int i = 1; i <= numberOfQuestions; i++){
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
        double percent = rc.prosentResultat(correctAnswers, numberOfQuestions);
        DecimalFormat numberFormat = new DecimalFormat("0.0");

        char grade = rc.gradeResult(percent);

        System.out.println(numberFormat.format(percent)+" %");
        System.out.println("That gives you the grade: "+grade);
    }
}