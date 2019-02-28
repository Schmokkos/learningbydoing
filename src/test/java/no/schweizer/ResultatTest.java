package no.schweizer;

import no.schweizer.controller.ResultatController;
import org.junit.Assert;
import org.junit.Test;

public class ResultatTest {

    private ResultatController rc = new ResultatController();

    @Test
    public void sjekkProsenter(){
        double v = rc.prosentResultat(37, 41);
        Assert.assertEquals(90.2439, v, 0.00001);
    }

    @Test
    public void sjekkKarakter(){
        Assert.assertEquals('A', rc.gradeResult(95.0));
        Assert.assertEquals('B', rc.gradeResult(80.0));
        Assert.assertEquals('C', rc.gradeResult(65.0));
        Assert.assertEquals('D', rc.gradeResult(45.0));
        Assert.assertEquals('E', rc.gradeResult(30.0));
        Assert.assertEquals('F', rc.gradeResult(15.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sjekkKarakterFeil(){
        rc.gradeResult(Double.NaN);
    }

    @Test
    public void sjekkIsItSolved(){
        boolean[] array = new boolean[3];
        Assert.assertFalse(rc.isItSolved(array));
        array[0] = true;
        Assert.assertFalse(rc.isItSolved(array));
        array[1] = true;
        Assert.assertFalse(rc.isItSolved(array));
        array[2] = true;
        Assert.assertTrue(rc.isItSolved(array));
    }

    @Test
    public void sjekkIsLetterInWord(){
        char[] array = {'a','b','c'};
        Assert.assertFalse(rc.isLetterInWord('g', array));
        Assert.assertFalse(rc.isLetterInWord('o', array));
        Assert.assertFalse(rc.isLetterInWord('i', array));
        Assert.assertTrue(rc.isLetterInWord('a', array));
        Assert.assertTrue(rc.isLetterInWord('b', array));
        Assert.assertTrue(rc.isLetterInWord('c', array));
    }

    @Test
    public void sjekkAreYouDead(){
        Assert.assertFalse(rc.areYouDead(0,5));
        Assert.assertFalse(rc.areYouDead(3,5));
        Assert.assertFalse(rc.areYouDead(5,8));
        Assert.assertTrue(rc.areYouDead(5,3));
        Assert.assertTrue(rc.areYouDead(5,5));
        Assert.assertTrue(rc.areYouDead(20,10));
    }

    @Test
    public void sjekkIsCalcCorrect(){
        Assert.assertFalse(rc.isCalcCorrect(54,55));
        Assert.assertFalse(rc.isCalcCorrect(1,-1));
        Assert.assertFalse(rc.isCalcCorrect(10,0));
        Assert.assertTrue(rc.isCalcCorrect(55,55));
        Assert.assertTrue(rc.isCalcCorrect(0,0));
        Assert.assertTrue(rc.isCalcCorrect(99885522,99885522));
    }

    @Test
    public void sjekkDidThePlayerLoose(){
        int[] array = {0,1,2,3,4};
        Assert.assertFalse(rc.didThePlayerLoose(array));
        array[4] = 0;
        Assert.assertFalse(rc.didThePlayerLoose(array));
        array[3] = 0;
        Assert.assertFalse(rc.didThePlayerLoose(array));
        array[2] = 0;
        Assert.assertTrue(rc.didThePlayerLoose(array));
        array[1] = 0;
        Assert.assertFalse(rc.didThePlayerLoose(array));
        array[0] = 1;
        Assert.assertTrue(rc.didThePlayerLoose(array));
    }

    @Test
    public void sjekkDidThePlayerWin(){
        int[] array = {0,1,2,3,4};
        Assert.assertFalse(rc.didThePlayerWin(array));
        array[4] = 0;
        Assert.assertFalse(rc.didThePlayerWin(array));
        array[3] = 0;
        Assert.assertFalse(rc.didThePlayerWin(array));
        array[2] = 0;
        Assert.assertFalse(rc.didThePlayerWin(array));
        array[1] = 0;
        Assert.assertTrue(rc.didThePlayerWin(array));
        array[0] = -1;
        Assert.assertTrue(rc.didThePlayerWin(array));
    }

}