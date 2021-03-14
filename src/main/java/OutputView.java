import com.sun.tools.javac.util.StringUtils;
import entity.ResultPositions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public void resultWinnerPrint(List<String> winners){
        String collect = winners.stream().collect(Collectors.joining(",","우승자는 ","입니다."));
        System.out.println(collect);

    }
}
