package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultPositions {
    private List<Car> resultCars;
    private final static String MARK = "-";

    private ResultPositions() {
    }

    public ResultPositions(List<Car> result) {
        this.resultCars = result;
    }

    public List<String> changePositionToMark() {
        List<String> markResult = new ArrayList<>();
        for (Car car : resultCars) {
            String markFullString = String.join("", Collections.nCopies(car.getPosition(), MARK));
            String addUser = car.getName() + " : " + markFullString;
            markResult.add(addUser);
        }
        return markResult;
    }

}
