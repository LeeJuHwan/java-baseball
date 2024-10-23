package baseball.domain.ball;

import java.util.ArrayList;
import java.util.List;

public class BallList {

    public static final int MAX_SIZE = 3;

    private final List<Ball> balls;

    public List<Ball> getBalls() {
        return new ArrayList<>(balls);
    }

    private BallList(List<Ball> balls) {
        if (balls.size() != MAX_SIZE) {
            throw new IllegalArgumentException("BallNumber는 3개가 최대 입니다.");
        }

        this.balls = balls;
    }

    public static BallList of(List<Ball> balls) {
        return new BallList(balls);
    }

    public boolean containsBall(Ball ball) {
        return balls.stream()
                .anyMatch(b -> b.isAnotherPositionSameNumber(ball));

    }

}
