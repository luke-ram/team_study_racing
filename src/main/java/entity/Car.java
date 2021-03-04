package entity;

import lombok.Getter;

@Getter
public class Car {

    private final static int START_POSITION = 0;
    private final static int CAN_MOVE_MIN_NUMBER = 3;
    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public void goOneStep() {
        this.position += 1;
    }

    public void checkCanMove(int random) {
        if (random > CAN_MOVE_MIN_NUMBER) {
            goOneStep();
        }
    }
}
