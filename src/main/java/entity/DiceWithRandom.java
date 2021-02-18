package entity;

import java.util.Random;

public class DiceWithRandom implements Dice{

    private final int MAX_RANDOM_NUMBER = 10;

    private Random randomNumber = new Random();

    @Override
    public int makeRandomNumber() {
        return randomNumber.nextInt(MAX_RANDOM_NUMBER);
    }
}
