package baseball.domain;

import baseball.domain.count.Count;
import java.util.List;

public class Score {

    private final long strikeCount;
    private final long ballCount;

    private Score(long strikeCount, long ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Score from(List<Count> counts) {
        long ballCount = counts.stream().filter(count -> count == Count.BALL).count();
        long strikeCount = counts.stream().filter(count -> count == Count.STRIKE).count();

        return new Score(strikeCount, ballCount);
    }

    public String getScreenMessage() {
        if (isStrikeCountGreaterThanZero() && isBallCountGreaterThanZero()) {
            return strikeCount + Count.STRIKE.description + " " + ballCount + Count.BALL.description;
        }

        if (isStrikeCountGreaterThanZero()) {
            return strikeCount + Count.STRIKE.description;
        }

        if (isBallCountGreaterThanZero()) {
            return ballCount + Count.BALL.description;
        }

        return Count.NOTHING.description;
    }

    private boolean isBallCountGreaterThanZero() {
        return ballCount > 0;
    }

    private boolean isStrikeCountGreaterThanZero() {
        return strikeCount > 0;
    }

}
