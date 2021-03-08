package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultPositions {
    private List<Integer> positions;
    private final static String MARK = "-";

    private ResultPositions() {
    }

    public ResultPositions(List<Integer> positions) {
        this.positions = positions;
    }

    public List<String> changePositionToMark() {
        List<String> markResult = new ArrayList<>();
        for (Integer position : positions) {
            String markFullString = String.join("", Collections.nCopies(position, MARK));
            markResult.add(markFullString);
        }
        return markResult;
    }

}
