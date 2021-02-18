package entity;

public class Car {

    private final int GO_ONE_STEP = 1;
    private final int GO_MIN_STANDARD = 4;
    private int position = 0;
    private String carName;

    public Car(String inputCarName) {
        this(inputCarName, 0);
    }

    public Car(String inputCarName, int position) {
        this.carName = inputCarName;
        this.position = position;
    }

    public void goPosition(boolean greaterCheck) {
        if (greaterCheck) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public void canGo(int number) {
        goPosition(number >= GO_MIN_STANDARD ? true : false);
    }

    public boolean isSamePosition(Integer inputposition) {
        return position == inputposition;
    }
}
