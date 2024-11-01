package com.github.curriculeon;

import com.github.curriculeon.arcade.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class NumberGuessGameTest {
    @Test
    public void generateRandomNumberTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        Integer randomNum =(Integer) numberGuessGame.generateRandomNumber();

        assertTrue(randomNum instanceof Integer);
    }
    //
    @Test
    public void getAndSetRandomNumberTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setRandomNumber(50);
        int expected = numberGuessGame.getRandomNumber();
        Assert.assertEquals(expected, 50);
    }

    @Test
    public void checkIfNumberIsTooHighTest(){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setRandomNumber(50);
        numberGuessGame.setUserNumber(70);
        numberGuessGame.checkIfNumberTooHighOrTooLow();

        System.setOut(originalOut);
        String actualOutput = outputStream.toString().trim(); // Capture and trim output



        Assert.assertEquals(actualOutput, "My Number is less than " +numberGuessGame.getUserNumber() );
    }


    @Test
    public void checkIfNumberIsTooLowTest(){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setRandomNumber(50);
        numberGuessGame.setUserNumber(30);
        numberGuessGame.checkIfNumberTooHighOrTooLow();

        System.setOut(originalOut);
        String actualOutput = outputStream.toString().trim(); // Capture and trim output



        Assert.assertEquals(actualOutput, "My Number is greater than " + numberGuessGame.getUserNumber());
    }

    @Test
    public void checkUserInputinputAmountTest(){
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.setRandomNumber(50);
        numberGuessGame.setUserNumber(30);
        numberGuessGame.checkIfNumberTooHighOrTooLow();
        numberGuessGame.checkIfNumberTooHighOrTooLow();
        numberGuessGame.checkIfNumberTooHighOrTooLow();

        Assert.assertEquals(3, numberGuessGame.getUserInputs().size());

    }



}
