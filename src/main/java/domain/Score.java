package domain;

import static core.SystemConstant.*;

public class Score {

    private int strikeCount;
    private int ballCount;

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String UN_HANDLE_MESSAGE = "낫싱";

    void clean() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void strikeIncrement() {
        this.strikeCount += 1;
    }

    public void ballIncrement() {
        this.ballCount += 1;
    }

    public String getScoreRecordResult() {
        if (isBallAndStrike()) {
            return ballCount + BALL_MESSAGE +  " " + strikeCount + STRIKE_MESSAGE;
        }

        if (isOnlyBall()) {
            return ballCount + BALL_MESSAGE;
        }

        if (isOnlyStrike()) {
            return strikeCount + STRIKE_MESSAGE;
        }

        return UN_HANDLE_MESSAGE;
    }

    private boolean isOnlyStrike() {
        return strikeCount > 0;
    }

    private boolean isOnlyBall() {
        return ballCount > 0;
    }

    private boolean isBallAndStrike() {
        return ballCount > 0 && strikeCount > 0;
    }

    public boolean isStrikeCountEqualToWinningStrikeCount() {
        return strikeCount == WINNING_STRIKE_COUNT;
    }

}
