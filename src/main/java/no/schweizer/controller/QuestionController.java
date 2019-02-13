package no.schweizer.controller;

import no.schweizer.lists.WordList;

import java.util.Random;
import java.util.Scanner;

public class QuestionController {

    public boolean questionCreator(int difficulty){
        Random rnum = new Random();
        Scanner scan = new Scanner(System.in);
        int numberRange;
        int operatorRange;

        //This switch sets the parameters needed for the difficulty.
        switch (difficulty) {
            case 1:
                //This case will only allow math equations with + and numbers 1-10
                numberRange = 10;
                operatorRange = 1;
                break;
            case 2:
                //This case will only allow math equations with + or - and numbers 1-25
                numberRange = 25;
                operatorRange = 2;
                break;
            case 3:
                //This case will only allow math equations with + or - and numbers 1-50
                numberRange = 50;
                operatorRange = 2;
                break;
            case 4:
                //This case will only allow math equations with +, - or * and numbers 1-50
                numberRange = 50;
                operatorRange = 3;
                break;
            case 5:
                //This case will only allow math equations with +, - or * and numbers 1-100
                numberRange = 100;
                operatorRange = 3;
                break;
            default:
                throw new IllegalArgumentException("Value difficulty was "+difficulty+" expected int 1-5");
        }

        int num1 = rnum.nextInt(numberRange);
        int num2 = rnum.nextInt(numberRange);
        num1++;
        num2++;
        int operator = rnum.nextInt(operatorRange);
        int result1;

        switch (operator+1) {
            case 1:
                //This case makes an addition (+) question
                System.out.println("What is: "+num1+"+"+num2+" ?");
                result1 = scan.nextInt();

                if (result1 == num1+num2){
                    System.out.println("Correct!");
                    return true;
                }
                else {
                    System.out.println("Wrong! Correct answer was: "+(num1+num2));
                    return false;
                }
            case 2:
                //This case makes an subtraction (-) question
                System.out.println("What is: "+num1+"-"+num2+" ?");
                result1 = scan.nextInt();

                if (result1 == num1-num2){
                    System.out.println("Correct!");
                    return true;
                }
                else {
                    System.out.println("Wrong! Correct answer was: "+(num1-num2));
                    return false;
                }
            case 3:
                //This case makes a multiplication (*) question
                System.out.println("What is: "+num1+"x"+num2+" ?");
                result1 = scan.nextInt();

                if (result1 == num1*num2){
                    System.out.println("Correct!");
                    return true;
                }
                else {
                    System.out.println("Wrong! Correct answer was: "+(num1*num2));
                    return false;
                }
            default:
                throw new IllegalArgumentException("Value operator was "+operator+" expected int 0-4");
        }
    }
    public String createWord(int length){
        Random rword = new Random();
        WordList wl = new WordList();
        String[] wordarray = wl.listOfWords(length);
        int num1 = rword.nextInt(wordarray.length-1);
        return wordarray[num1];
    }
}
