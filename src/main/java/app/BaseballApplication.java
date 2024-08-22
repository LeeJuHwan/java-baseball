package app;

import base.Application;
import domain.Computer;
import domain.Judgment;
import domain.Score;
import domain.User;
import io.InputHandler;
import io.OutputHandler;
import java.util.ArrayList;
import core.AppException;

import static core.SystemConstant.*;


public class BaseballApplication implements Application {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        Judgment judgment = readyToGame();
        outputHandler.gameStartCommentPrint();

        applicationToGameStart(judgment);
    }

    public String selectGameRestartOrStop() {
        outputHandler.gameEndCommentPrint();
        return inputHandler.getUserInput();
    }

    public boolean isGameRestart(String gameFlag) {
        return gameFlag.equals(GAME_RESTART_FLAG);
    }

    public boolean isGameStop(String gameFlag) {
        return gameFlag.equals(GAME_STOP_FLAG);
    }

    private void applicationToGameStart(Judgment judgment) {
        try {
            actionToGameStartByJudgement(judgment);

        } catch (AppException e) {
            OutputHandler.printAppExceptionMessage(e);

            applicationToGameStart(judgment);
        }
    }

    private void actionToGameStartByJudgement(Judgment judgment) {
        boolean isGameSet = false;

        while (hasGameRunning(isGameSet)) {
            String userInputNumber = userAction();
            ArrayList<String> userActionResult = userReadyComplete(userInputNumber);
            Score score = judgment.judge(userActionResult);
            isGameSet = score.isStrikeCountEqualToWinningStrikeCount();
        }
    }

    private static boolean hasGameRunning(boolean isGameSet) {
        return !isGameSet;
    }

    private ArrayList<String> userReadyComplete(String userInputNumber) {
        User user = new User(userInputNumber);
        return user.getUserInputNumbers();
    }

    private String userAction() {
        outputHandler.questionToUserAboutInputNumber();
        return inputHandler.getUserInput();
    }

    private Judgment readyToGame() {
        Computer computer = new Computer();
        return new Judgment(computer);
    }


}
