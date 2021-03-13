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

        Car a = new Car("A", 3);
        Car b = new Car("B", 5);
        Car c = new Car("C", 5);

        ResultPositions resultPositions = new ResultPositions(Arrays.asList(a,b,c));
        List<String> resultMark = resultPositions.changePositionToMark();

        List<String> expectedResultMark = Arrays.asList(
                "A : ---",
                "B : -----",
                "C : -----"
        );

        Assertions.assertThat(resultMark).containsExactlyElementsOf(expectedResultMark);

    }
}
