package no.schweizer.controller;

public class ResultatController {

    public double prosentResultat(int antallRiktige, int antallMulige) {
        return ((double) antallRiktige / antallMulige) * 100;
    }

}
