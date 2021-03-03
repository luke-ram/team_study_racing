package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//일급 컬렉션, 비지니스에 종속적인 자료구조를 만든다.
//값과 로직이 함께 존재한다.
public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for (int index = 0; index < carCount; index++) {
            cars.add(new Car());
        }
    }

    public List<Integer> playGameWithRandom(RandomMaker randomMaker) {

        return cars.stream().map(car -> {
            car.checkCanMove(randomMaker.create());
            return car.getPosition();
        }).collect(Collectors.toList());

    }

    public List<ResultPositions> playGameForGameCount(int gameCount) {

        List<ResultPositions> resultPositions = new ArrayList<>();
        RandomMaker randomMaker = new RandomMaker();

        for (int index = 0; index < gameCount; index++) {

            List<Integer> result = playGameWithRandom(randomMaker);
            resultPositions.add(new ResultPositions(result));
        }

        return resultPositions;
    }
}
