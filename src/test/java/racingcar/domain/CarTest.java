package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @DisplayName("정상적인 이름인 경우 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"중간곰", "다니", "포비", "씨유", "브라운", "harry"})
    public void createCar_정상적인_이름인_경우(String name) {
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름의 길이가 범위를 벗어난 경우 예외 발생")
    @Test
    public void createCar_이름의_길이가_범위를_벗어난_경우() {
        final String SHORT_CAR_NAME = "";
        final int MAXIMUM_LENGTH = 5;
        final String LONG_CAR_NAME = new String(new char[MAXIMUM_LENGTH + 1]);

        assertThatThrownBy(() -> {
            new Car(SHORT_CAR_NAME);
            new Car(LONG_CAR_NAME);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 전진 성공")
    @Test
    public void moveCar() {
        final int MOVEMENT = 10;

        Car car = new Car("pobi");

        for (int i = 0; i < MOVEMENT; i++) {
            car.move();
        }

        assertThat(car.getPosition())
                .isEqualTo(MOVEMENT);
    }
}