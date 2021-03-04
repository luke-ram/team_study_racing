package entity;

import java.util.Random;

public class RandomMaker implements NumberMaker {

    private Random random  = new Random();

    @Override
    public int create() {
        return random.nextInt(10);
    }
}
