package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.count.Count;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ScoreTest {

    @Test
    @DisplayName("카운트 리스트 스코어 낫띵")
    void test_스코어_낫띵() {
        Score score = Score.from(
                List.of(
                        Count.NOTHING,
                        Count.NOTHING,
                        Count.NOTHING
                )
        );
        assertThat(score.getScreenMessage()).isEqualTo("낫띵");
    }


    @ParameterizedTest
    @DisplayName("카운트 리스트 스코어 스트라이크 카운트 검증")
    @CsvSource(value = {"1,1스트라이크", "2,2스트라이크", "3,3스트라이크"})
    void test_스코어_스트라이크_메세지(int strikeCount, String scoreMessage) {
        List<Count> ballList = new ArrayList<>();

        for (int i = 0; i < strikeCount; i++) {
            ballList.add(Count.STRIKE);
        }

        while (ballList.size() < 3) {
            ballList.add(Count.NOTHING);
        }

        Score score = Score.from(ballList);

        assertThat(score.getScreenMessage()).isEqualTo(scoreMessage);
    }


    @ParameterizedTest
    @DisplayName("카운트 리스트 스코어 볼 카운트 검증")
    @CsvSource(value = {"1,1볼", "2,2볼", "3,3볼"})
    void test_스코어_볼_메세지(int ballCount, String scoreMessage) {
        List<Count> ballList = new ArrayList<>();

        for (int i = 0; i < ballCount; i++) {
            ballList.add(Count.BALL);
        }

        while (ballList.size() < 3) {
            ballList.add(Count.NOTHING);
        }

        Score score = Score.from(ballList);

        assertThat(score.getScreenMessage()).isEqualTo(scoreMessage);
    }

    @Test
    @DisplayName("카운트 리스트 스코어 1볼 1스트라이크")
    void test_스코어_1볼_1스트라이크() {
        Score score = Score.from(
                List.of(
                        Count.BALL,
                        Count.STRIKE,
                        Count.NOTHING
                )
        );

        assertThat(score.getScreenMessage()).isEqualTo("1스트라이크 1볼");
    }
}