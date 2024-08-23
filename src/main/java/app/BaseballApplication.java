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


    public void startGame() {
        Judgment judgment = readyToGame();
        outputHandler.gameStartCommentPrint();

        boolean isGameRunning = true;
        while (isGameRunning) {
            run(judgment);

            isGameRunning = pauseForUserGameRunOptionSelect();
        }
    }

    private String userSelectGameRestartOrStop() {
        outputHandler.gameEndCommentPrint();
        return inputHandler.getUserInput();
    }

    private boolean isGameRestart(String gameFlag) {
        return GAME_RESTART_FLAG.equals(gameFlag);
    }

    private boolean isGameStop(String gameFlag) {
        return GAME_STOP_FLAG.equals(gameFlag);
    }

    private void run(Judgment judgment) {
        try {
            actionToGameStartByJudgement(judgment);

        } catch (AppException e) {
            outputHandler.printAppExceptionMessage(e);

            run(judgment);
        }
    }

    private boolean pauseForUserGameRunOptionSelect() {
        try {
            String gameFlag = userSelectGameRestartOrStop();

            return isGameContinue(gameFlag);

        } catch (AppException e) {
            outputHandler.printAppExceptionMessage(e);
            return pauseForUserGameRunOptionSelect();
        }
    }

    private boolean isGameContinue(String gameFlag) {
        if (isGameRestart(gameFlag)) {
            return true;
        }

        if (isGameStop(gameFlag)) {
            return false;
        }

        throw new AppException("게임 시작 명령어를 잘못 입력 하였습니다.");
    }

    private void actionToGameStartByJudgement(Judgment judgment) {
        boolean isGameSet = false;

        while (hasGameRun(isGameSet)) {
            String userInputNumber = userAction();
            ArrayList<String> userActionResult = userReadyComplete(userInputNumber);

            Score score = judgment.judge(userActionResult);

            String scoreResultMessage = score.getScoreRecordResult();
            outputHandler.printMessage(scoreResultMessage);

        boolean isGameSet = score.isStrikeCountEqualToWinningStrikeCount();

        if (stillGameRunning(isGameSet)) {
            actionToGameStartByJudgement(judgment);
        }
    }

    private boolean stillGameRunning(boolean isGameSet) {
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
        return new Judgment(new Computer());
    }
}
