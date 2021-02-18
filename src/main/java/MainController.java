import entity.Car;
import entity.Cars;
import entity.Dice;
import entity.DiceWithRandom;

import java.util.List;

public class MainController {

    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();
        inputScanner.getUserInput();
        Cars cars = new Cars(inputScanner.getNameList());

        OutputView outputView = new OutputView();
        Dice dice = new DiceWithRandom();

        for (int time = 0; time < inputScanner.getInputTime(); time++) {

            cars.playGame(dice);
            List<Car> carList = cars.getCarList();
            outputView.resultPrint(carList);
            System.out.println();
        }

        List<String> winner = cars.getWinner();
        outputView.printWinner(winner);
    }
}