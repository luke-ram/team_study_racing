package entity;

public class DiceWithInput implements Dice{

    private int number;

    public DiceWithInput(int number) {
        this.number = number;
    }

    @Override
    public int makeRandomNumber() {
        return this.number;
    }
}
