package entity;

import lombok.Getter;

@Getter
public class Car implements Comparable<Car> {

    private final static int START_POSITION = 0;
    private final static int CAN_MOVE_MIN_NUMBER = 3;

    private final static String EMPTY_NAME = "";

    private int position;

    private String name;

    public Car(String name){
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void goOneStep() {
        this.position += 1;
    }

    public void checkCanMove(NumberMaker numberMaker) {
        if ( numberMaker.create() > CAN_MOVE_MIN_NUMBER) {
            goOneStep();
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position, car.getPosition());
    }
}
