package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.ball.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    @ParameterizedTest
    @DisplayName("Ball 객체의 number 인자는 1부터 9까지의 숫자만 입력이 가능하다")
    @CsvSource({"0,0", "0, 10"})
    void test_Ball_객체_number_인자_오류(int position, int number) {
        assertThatThrownBy(() -> {
            Ball.of(position, number);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력입니다.");
    }

    @Test
    @DisplayName("Ball 객체의 position 인자는 0보다 낮을 수 없다")
    void test_Ball_객체_position_인자_오류() {
        assertThatThrownBy(() -> Ball.of(-1, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력입니다.");
    }

    @ParameterizedTest
    @DisplayName("Ball 객체는 0보다 큰 position과 1부터 9까지의 number만 입력이 가능하다")
    @CsvSource({"0, 1", "0, 9"})
    void test_Ball_객체_생성_성공(int position, int number) {
        assertThat(Ball.of(position, number)).isInstanceOf(Ball.class);
    }
}
