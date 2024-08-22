import app.BaseballApplication;
import base.Application;
import core.AppException;
import io.OutputHandler;

public class Main {

    public static void main(String[] args) {
        try {
            startGame();
        } catch (Exception e) {
            OutputHandler.printDefaultExceptionMessage(e);
        }
    }

    private static void startGame() {
        boolean isGameRunning = true;

        while (isGameRunning) {
            Application baseballApplication = new BaseballApplication();
            baseballApplication.run();

            isGameRunning = getGameStatusOption(baseballApplication);
        }
    }

    private static boolean getGameStatusOption(Application baseballApplication) {

        try {
            String gameFlag = baseballApplication.selectGameRestartOrStop();

            if (baseballApplication.isGameRestart(gameFlag)) {
                return true;
            }

            if (baseballApplication.isGameStop(gameFlag)) {
                return false;
            }

            throw new AppException("게임 시작 명령어를 잘못 입력 하였습니다.");

        } catch (AppException e) {
            OutputHandler.printAppExceptionMessage(e);
            return getGameStatusOption(baseballApplication);
        }
    }
}
