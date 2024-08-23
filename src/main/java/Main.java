import app.BaseballApplication;
import base.Application;
import core.AppException;
import io.OutputHandler;

public class Main {

    public static void main(String[] args) {
        Application baseballApplication = new BaseballApplication();

        try {
            startGame(baseballApplication);
        } catch (Exception e) {
            OutputHandler.printDefaultExceptionMessage(e);
        }
    }

    private static void startGame(Application gameApplication) {
        boolean isGameRunning = true;

        while (isGameRunning) {
            gameApplication.run();

            isGameRunning = getGameStatusOption(gameApplication);
        }
    }

    private static boolean getGameStatusOption(Application gameApplication) {

        try {
            String gameFlag = gameApplication.selectGameRestartOrStop();

            if (gameApplication.isGameRestart(gameFlag)) {
                return true;
            }

            if (gameApplication.isGameStop(gameFlag)) {
                return false;
            }

            throw new AppException("게임 시작 명령어를 잘못 입력 하였습니다.");

        } catch (AppException e) {
            OutputHandler.printAppExceptionMessage(e);
            return getGameStatusOption(gameApplication);
        }
    }
}
