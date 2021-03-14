import entity.Cars;
import entity.ResultPositions;

import java.util.List;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String inputNames = inputView.inputNames();
        int gameCount = inputView.inputGameCount();

        Cars cars = new Cars(inputNames);
        List<ResultPositions> resultPositions = cars.playGameForGameCount(gameCount);

        outputView.resultPrint(resultPositions);
        outputView.resultWinnerPrint(cars.getWinnerPlayer());

    }
}
