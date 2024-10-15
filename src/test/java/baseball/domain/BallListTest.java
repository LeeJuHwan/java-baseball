package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BallListTest {

    @Test
    @DisplayName("BallList 컬렉션의 요소는 3개를 넘을 수 없다")
    void BallList_요소_갯수_초과() {
        // Given
        List<Ball> balls = List.of(
                Ball.from(1),
                Ball.from(2),
                Ball.from(3),
                Ball.from(4)
        );

        // When
        assertThatThrownBy(() -> BallList.of(balls))
                // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("BallNumber는 3개가 최대 입니다.");
    }

    @Test
    @DisplayName("BallList 컬렉션의 요소는 3개 보다 적을 수 없다")
    void BallList_요소_갯수_미만() {
        // Given
        List<Ball> balls = List.of(
                Ball.from(1),
                Ball.from(2)
        );

        // When
        assertThatThrownBy(() -> BallList.of(balls))
                // Then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("BallNumber는 3개가 최대 입니다.");
    }
}
