package com.github.curriculeon;

import com.github.curriculeon.arcade.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SlotsGameTest {
    SlotsGame slots;

    @Before
    public void setUp() throws Exception{
        slots = new SlotsGame();
    }

    @Test
    public final void testSpinWheelTrue(){
        //given boolean
        //return arraylist
        boolean decision = true;
        //calls spinWheel method to generate an arrayList of random numbers of size 5
        ArrayList<Integer> arrayList = slots.spinWheelYes(decision, 5);
        Assert.assertEquals(arrayList.size(), 5);
    }

    @Test
    public final void testCheckForMatchThree(){
        //given an arraylist of size 5 with random numbers from 0-9 check if there are 3 matching numbers
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,1,1,4,5));
        boolean result = slots.checkForMatchThree(arrayList);
        Assert.assertTrue(result);
    }

    @Test
    public final void testCheckForMatchThree2(){
        //given an arraylist of size 5 with random numbers from 0-9 check if there are 3 matching numbers
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,1,3,4,5));
        boolean result = slots.checkForMatchThree(arrayList);
        Assert.assertFalse(result);
    }

    @Test
    public final void testCheckForMatchFive(){
        //given an arraylist of size 5 with random numbers from 0-9 check if there are 5 matching numbers
        //creates an ArrayList with random numbers but using all 1's for testing purposes
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        boolean result = slots.checkForMatchFive(arrayList);
        Assert.assertTrue(result);
    }

    @Test
    public final void testCheckForMatchFive2(){
        //given an arraylist of size 5 with random numbers from 0-9 check if there are 5 matching numbers
        //creates an ArrayList with random numbers but using all 1's for testing purposes
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 5));
        boolean result = slots.checkForMatchFive(arrayList);
        Assert.assertFalse(result);
    }

    @Test
    public final void payOutFor3Test(){
        //return int times 15

        double results = slots.payOutForThree(15, 1);
        Assert.assertEquals(results, 15, 0.01);
    }

    @Test
    public final void payOutFor3Test2(){
        //return int times 15

        double results = slots.payOutForThree(15, 5);
        Assert.assertEquals(results, 75, 0.01);
    }

    @Test
    public final void payOutFor5Test(){
        //return int times 40
        double results = slots.payOutForFive(100, 1);
        Assert.assertEquals(results, 100, 0.01);
    }

    @Test
    public final void payOutFor5Test2(){
        //return int times 40
        double results = slots.payOutForFive(100, 5);
        Assert.assertEquals(results, 500, 0.01);
    }

    @Test
    public final void payOutJackpot(){
        //given a boolean, return int times 100
        double results = slots.payOutForJackpot(1000, 1);
        Assert.assertEquals(results, 1000, 0.01);
    }

    @Test
    public final void payOutJackpot2(){
        //given a boolean, return int times 100
        double results = slots.payOutForJackpot(1000, 5);
        Assert.assertEquals(results, 5000, 0.01);
    }
}
