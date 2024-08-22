package base;

public interface Application {

    boolean isGameRestart(String gameFlag);

    boolean isGameStop(String gameFlag);

    String selectGameRestartOrStop();

    void run();

}
