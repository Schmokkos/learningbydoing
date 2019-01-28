package no.schweizer;

import no.schweizer.controller.ResultatController;
import org.junit.Test;

public class ProsentTest {

    @Test
    public void sjekkProsenter(){
        ResultatController rc = new ResultatController();

        double v = rc.prosentResultat(37, 41);

        double penere = Math.floor(v);
    }

}
