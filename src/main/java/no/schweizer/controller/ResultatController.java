package no.schweizer.controller;

public class ResultatController {

    public double prosentResultat(int antallRiktige, int antallMulige) {
        return ((double) antallRiktige / antallMulige) * 100;
    }

    public char gradeResult(double prosent) {

        if (prosent <= (100 / 6)) {
            return 'F';
        }
        else if (prosent <= (100 / 6 * 2)) {
            return 'E';
        }
        else if (prosent <= (100 / 6 * 3)) {
            return 'D';
        }
        else if (prosent <= (100 / 6 * 4)) {
            return 'C';
        }
        else if (prosent <= (100 / 6 * 5)) {
            return 'B';
        }
        else if (prosent >= (100 / 6 * 5)){
            return 'A';
        }
        else {
            return 'X';
        }
    }

}
