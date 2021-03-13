package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//일급 컬렉션, 비지니스에 종속적인 자료구조를 만든다.
//값과 로직이 함께 존재한다.
public class Cars {

    private List<Car> cars = new ArrayList<>();


    public Cars(String inputNames){
        List<String> parserResult = inputNameParser(inputNames);
        List<String> names = checkNameLength(parserResult);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }


    public static List<String> inputNameParser(String inputNames) {

        if(inputNames.isEmpty()){
            throw new IllegalArgumentException("빈값을 입력하였습니다.");
        }

        return Arrays.stream(inputNames.split(",", -1))
                .collect(Collectors.toList());


    }

    public static List<String> checkNameLength(List<String> names) {
        boolean isWrong = names.stream().allMatch(name -> name.length() > 4);

        if(isWrong){
            throw new IllegalArgumentException("이름은 다섯글자를 넘을 수 없습니다.");
        }
        return names;
    }

    public List<Car> playGameWithRandom(NumberMaker numberMaker) {

        return cars.stream().map(car -> {
            car.checkCanMove(numberMaker.create());
            return new Car(car.getName(), car.getPosition());
        }).collect(Collectors.toList());

    }

    public NumberMaker makeNumberRole() {
        return new RandomMaker();
    }

    public List<ResultPositions> playGameForGameCount(int gameCount) {

        List<ResultPositions> resultPositions = new ArrayList<>();
        NumberMaker numberMaker = makeNumberRole();

        for (int index = 0; index < gameCount; index++) {

            List<Car> result = playGameWithRandom(numberMaker);
            resultPositions.add(new ResultPositions(result));
        }

        return resultPositions;
    }
}
