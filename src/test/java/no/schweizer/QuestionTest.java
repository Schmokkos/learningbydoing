package no.schweizer;

import no.schweizer.controller.QuestionController;
import org.junit.Assert;
import org.junit.Test;

public class QuestionTest {

    private QuestionController qc = new QuestionController();

    @Test
    public void sjekkCreateWord(){
        Assert.assertNotNull(qc.createWord(5));
        Assert.assertNotNull(qc.createWord(6));
        Assert.assertNotNull(qc.createWord(7));

        //Unit test for sentence building
        Assert.assertNotNull(qc.createWord(0));
    }
}
