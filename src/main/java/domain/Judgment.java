package domain;

import java.util.ArrayList;

public class Judgment {

    private final Score score = new Score();
    private final ArrayList<String> computerRandomNumbers;


    public Judgment(Computer computer) {
        this.computerRandomNumbers = computer.readyToGameStart();
        System.out.println("computerRandomNumbers = " + computerRandomNumbers);
    }

    public Score judge(ArrayList<String> userInputNumbers) {
        score.clean();

        for (int seq = 0; seq < userInputNumbers.size(); seq++) {
            scoreRecord(userInputNumbers, seq);
        }
        score.printScoreRecordResult();
        return score;
    }

    private void scoreRecord(ArrayList<String> userInputNumbers, int i) {
        if (isStrike(userInputNumbers, i)) {
            score.strikeIncrement();
            return;
        }

        if (isBall(userInputNumbers, i)) {
            score.ballIncrement();
        }
    }

    private boolean isBall(ArrayList<String> userInputNumbers, int i) {
        return computerRandomNumbers.contains(userInputNumbers.get(i));
    }

    private boolean isStrike(ArrayList<String> userInputNumbers, int i) {
        return computerRandomNumbers.get(i).equals(userInputNumbers.get(i));
    }
}
