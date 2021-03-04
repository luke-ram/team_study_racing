import entity.ResultPositions;

import java.util.List;

public class OutputView {

    public void resultPrint(List<ResultPositions> resultPositions) {
        for (ResultPositions resultPosition : resultPositions) {
            printConsole(resultPosition);
            System.out.println();
        }

    }

    private void printConsole(ResultPositions resultPosition) {
        resultPosition.changePositionToMark().stream().forEach(mark -> {
            System.out.println(mark);
        });
    }
}
