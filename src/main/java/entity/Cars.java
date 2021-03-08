package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//일급 컬렉션, 비지니스에 종속적인 자료구조를 만든다.
//값과 로직이 함께 존재한다.
public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for (int index = 0; index < carCount; index++) {
            cars.add(new Car());
        }
    }

    public List<Integer> playGameWithRandom(NumberMaker numberMaker) {

        return cars.stream().map(car -> {
            car.checkCanMove(numberMaker.create());
            return car.getPosition();
        }).collect(Collectors.toList());

    }

    public NumberMaker makeNumberRole() {
        return new RandomMaker();
    }

    public List<ResultPositions> playGameForGameCount(int gameCount) {

        List<ResultPositions> resultPositions = new ArrayList<>();
        NumberMaker numberMaker = makeNumberRole();

        for (int index = 0; index < gameCount; index++) {

            List<Integer> result = playGameWithRandom(numberMaker);
            resultPositions.add(new ResultPositions(result));
        }

        return resultPositions;
    }
}
