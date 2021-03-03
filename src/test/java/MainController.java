import entity.Cars;
import entity.ResultPositions;

import java.util.List;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int carCount = inputView.inputCarCount();
        int gameCount = inputView.inputGameCount();

        Cars cars = new Cars(carCount);
        List<ResultPositions> resultPositions = cars.playGameForGameCount(gameCount);

        outputView.resultPrint(resultPositions);




    }
}
