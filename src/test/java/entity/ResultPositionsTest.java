package entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultPositionsTest {

    @Test
    @DisplayName("현재 위치값을 -로 바꾼 리스트를 반환한다.")
    public void changePositionToMarkTest() {

        ResultPositions resultPositions = new ResultPositions(Arrays.asList(3, 3, 5));
        List<String> resultMark = resultPositions.changePositionToMark();

        List<String> expectedResultMark = Arrays.asList(
                "---",
                "---",
                "-----"
        );

        Assertions.assertThat(resultMark).containsExactlyElementsOf(expectedResultMark);

    }
}
