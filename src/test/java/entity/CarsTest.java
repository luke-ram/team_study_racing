package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @Test
    @DisplayName("숫자 생성값이 4 이상일때 position위치는 1이다")
    public void playGame_random_Number_More_than_4() {

        Cars cars = new Cars("유저1");
        List<Car> result = cars.playGameWithRandom(new RandomMaker() {
            @Override
            public int create() {
                return 4;
            }
        });
        assertThat(result.get(0).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 생성값이 4미만일때 position위치는 0이다")
    public void playGame_random_Number_Under_4() {

        Cars cars = new Cars("유저1");
        List<Car> result = cars.playGameWithRandom(new RandomMaker() {
            @Override
            public int create() {
                return 3;
            }
        });
        assertThat(result.get(0).getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("숫자 생성 규칙을 오버라이딩하고, 앞으로 전진 못했을때의 결과를 받는다.")
    public void playGameForGameCountTest_Stop() {

        Cars cars = new Cars("유저1") {
            @Override
            public NumberMaker makeNumberRole() {
                return () -> 1;
            }
        };

        List<ResultPositions> resultPositions = cars.playGameForGameCount(1);
        assertThat(resultPositions.get(0).changePositionToMark()).isEqualTo(Arrays.asList("유저1 : "));

    }

    @Test
    @DisplayName("숫자 생성 규칙을 오버라이딩하고, 앞으로 전진 못했을때의 결과를 받는다.")
    public void playGameForGameCountTest_Go_ONE_STEP() {

        Cars cars = new Cars("유저1") {
            @Override
            public NumberMaker makeNumberRole() {
                return () -> 5;
            }
        };

        List<ResultPositions> resultPositions = cars.playGameForGameCount(1);
        assertThat(resultPositions.get(0).changePositionToMark()).isEqualTo(Arrays.asList("유저1 : -"));

    }

    @Test
    @DisplayName("이름 문자열을 , 으로 파싱한다.")
    public void inputNameParserTest() {
        List<String> three_names = Cars.inputNameParser("홍길동, 아무개, 호수람");
        assertThat(three_names.size()).isEqualTo(3);

        List<String> four_names = Cars.inputNameParser("홍길동, 아무개, 호수람, 고구마");
        assertThat(four_names.size()).isEqualTo(4);

    }

    @Test
    @DisplayName("빈 문자열이 입력됬을때는 에러를 발생 시킨다.")
    public void inputNameEmptyException() {

        assertThrows(IllegalArgumentException.class, () -> {
            Cars.inputNameParser("");
        });
    }

    @Test
    @DisplayName("이름이 5글자 이하일때 그대로 리턴")
    public void checkNameLengthTest() {
        List<String> names = Cars.checkNameLength(Arrays.asList("홍길동", "아", "아무", "김아무개"));
        assertThat(names.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("이름이 5글자가 넘으면 에러 발생")
    public void checkNameLengthTest_Error() {
        assertThrows(IllegalArgumentException.class, () -> {
            Cars.checkNameLength(Arrays.asList("이름이다섯"));
        });
    }

    @Test
    public void dummyTest(){

        String sample = "a,b,c,";
        String[] split = sample.split(",");
        for (String s : split) {
            System.out.println("s = " + s);
        }


    }



}
