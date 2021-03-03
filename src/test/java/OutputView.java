import entity.ResultPositions;

import java.util.List;

public class OutputView {

    public void resultPrint(List<ResultPositions> resultPositions){
        for (ResultPositions resultPosition : resultPositions) {
            printConsole(resultPosition);
        }

    }

    private void printConsole(ResultPositions resultPosition) {
        //리턴 List<String> 출력
    }
}
