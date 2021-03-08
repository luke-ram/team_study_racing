package entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("숫자 생성값이 4 이상일때 position위치는 1이다")
    public void playGame_random_Number_More_than_4() {

        Cars cars = new Cars(1);
        List<Integer> positions = cars.playGameWithRandom(new RandomMaker() {
            @Override
            public int create() {
                return 4;
            }
        });
        Assertions.assertThat(positions).containsExactlyElementsOf(Arrays.asList(1));
    }

    @Test
    @DisplayName("숫자 생성값이 4미만일때 position위치는 0이다")
    public void playGame_random_Number_Under_4() {

        Cars cars = new Cars(1);
        List<Integer> positions = cars.playGameWithRandom(new RandomMaker() {
            @Override
            public int create() {
                return 3;
            }
        });
        Assertions.assertThat(positions).containsExactlyElementsOf(Arrays.asList(0));

    }

    @Test
    @DisplayName("숫자 생성 규칙을 오버라이딩하고, 앞으로 전진 못했을때의 결과를 받는다.")
    public void playGameForGameCountTest_Stop() {

        Cars cars = new Cars(1) {
            @Override
            public NumberMaker makeNumberRole() {
                return () -> 1;
            }
        };

        List<ResultPositions> resultPositions = cars.playGameForGameCount(1);
        Assertions.assertThat(resultPositions.get(0).changePositionToMark()).isEqualTo(Arrays.asList(""));

    }

    @Test
    @DisplayName("숫자 생성 규칙을 오버라이딩하고, 앞으로 전진 못했을때의 결과를 받는다.")
    public void playGameForGameCountTest_Go_ONE_STEP() {

        Cars cars = new Cars(1) {
            @Override
            public NumberMaker makeNumberRole() {
                return () -> 5;
            }
        };

        List<ResultPositions> resultPositions = cars.playGameForGameCount(1);
        Assertions.assertThat(resultPositions.get(0).changePositionToMark()).isEqualTo(Arrays.asList("-"));

    }


}
