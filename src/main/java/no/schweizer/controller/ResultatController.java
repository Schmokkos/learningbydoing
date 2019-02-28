package no.schweizer.controller;

public class ResultatController {

    public double prosentResultat(int antallRiktige, int antallMulige) {
        return ((double) antallRiktige / antallMulige) * 100;
    }

    public char gradeResult(double prosent) {
        double base = (100.0 / 6.0);
        if (prosent <= base) {
            return 'F';
        }
        else if (prosent <= (base * 2)) {
            return 'E';
        }
        else if (prosent <= (base * 3)) {
            return 'D';
        }
        else if (prosent <= (base * 4)) {
            return 'C';
        }
        else if (prosent <= (base * 5)) {
            return 'B';
        }
        else if (prosent >= (base * 5)){
            return 'A';
        }
        else {
            throw new IllegalArgumentException("Value prosent was "+prosent+" expected double");
        }
    }

    public boolean isItSolved(boolean[] array){
        for (boolean b:array) {
            if (!b) return false;
        }
        return true;
    }
    public boolean isLetterInWord(char letter, char[] letters){
        for (char l:letters) {
            if (l == letter) return true;
        }
        return false;
    }
    public boolean areYouDead(int wrong, int limit){
        return (wrong >= limit);
    }

    public boolean isCalcCorrect(int num1, int num2){
        if (num1==num2){
            System.out.println("Correct!");
            return true;
        }
        else {
            System.out.println("Wrong! Correct answer was: "+num2);
            return false;
        }
    }

    public boolean didThePlayerLoose(int[] array){
        int total = 0;
        for (int a:array
             ) {
            total = total + a;
        }
        return (total == 1);
    }

    public boolean didThePlayerWin(int[] array){
        int total = 0;
        for (int a:array
        ) {
            total = total + a;
        }
        return (total < 1);
    }
}
