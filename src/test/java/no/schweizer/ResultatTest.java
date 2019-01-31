package no.schweizer;

import no.schweizer.controller.ResultatController;
import org.junit.Assert;
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

        Assert.assertEquals('A', rc.gradeResult(95.0));
        Assert.assertEquals('B', rc.gradeResult(80.0));
        Assert.assertEquals('C', rc.gradeResult(65.0));
        Assert.assertEquals('D', rc.gradeResult(45.0));
        Assert.assertEquals('E', rc.gradeResult(30.0));
        Assert.assertEquals('F', rc.gradeResult(15.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sjekkKarakterFeil(){
        ResultatController rc = new ResultatController();

        rc.gradeResult(Double.NaN);
    }

}