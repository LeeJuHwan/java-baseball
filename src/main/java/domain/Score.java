package domain;

import static core.SystemConstant.*;

import io.OutputHandler;

public class Score {

    private int strikeCount;
    private int ballCount;


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

    public void printScoreRecordResult() {
        if (ballCount > 0 && strikeCount > 0) {
            OutputHandler.printMessage(ballCount + "볼 " + strikeCount + "스트라이크");
            return;
        }

        if (ballCount > 0) {
            OutputHandler.printMessage(ballCount + "볼");
            return;
        }

        if (strikeCount > 0) {
            OutputHandler.printMessage(strikeCount + "스트라이크");
            return;
        }

        OutputHandler.printMessage("낫싱");
    }

    public boolean isStrikeCountEqualToWinningStrikeCount() {
        return strikeCount == WINNING_STRIKE_COUNT;
    }

}
