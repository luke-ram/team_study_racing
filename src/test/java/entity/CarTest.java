package entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("유저1");
    }

    @Test
    @DisplayName("car 생성")
    public void createCar() {
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("한칸 이동")
    public void moveCar() {
        car.goOneStep();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("숫자가 4 이상시 이동")
    public void move_greater_than_4() {
        car.checkCanMove(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 4미만시 이동안함")
    public void not_move_less_4() {
        car.checkCanMove(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}
