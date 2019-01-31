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
}
