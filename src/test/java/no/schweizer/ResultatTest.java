package no.schweizer;

import no.schweizer.controller.ResultatController;
import org.junit.Test;

public class ResultatTest {

    @Test
    public void sjekkProsenter(){
        ResultatController rc = new ResultatController();

        double v = rc.prosentResultat(37, 41);
    }

    @Test
    public void sjekkKarakter(){
        ResultatController rc = new ResultatController();

        char c = rc.gradeResult(50.0);
    }

}