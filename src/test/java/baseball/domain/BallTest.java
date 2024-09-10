package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

    @ParameterizedTest
    @DisplayName("BallNumber는 1부터 9까지의 숫자만 입력이 가능하다")
    @ValueSource(ints = {0, 10})
    void test_예외_케이스(int fixture) {
        assertThatThrownBy(() -> {
            Ball ball = Ball.from(fixture);
        })      // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9까지 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("BallNumber는 1부터 9까지의 숫자만 입력이 가능하다")
    @ValueSource(ints = {1, 9})
    void test_정상_케이스(int fixture) {
        Ball ballNumber = Ball.from(fixture);

        assertThat(ballNumber).isInstanceOf(Ball.class);
    }
}
