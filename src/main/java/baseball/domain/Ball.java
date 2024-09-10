package baseball.domain;

public class Ball {

    public static final int MIN = 1;
    public static final int MAX = 9;
    private final int number;

    private Ball(int number) {
        if (ballInputValidation(number)) {
            throw new IllegalArgumentException("1부터 9까지 숫자만 입력이 가능합니다.");
        }
        this.number = number;
    }

    public static Ball from(int number) {
        return new Ball(number);
    }

    private boolean ballInputValidation(int inputNumber) {
        return inputNumber < MIN || inputNumber > MAX;
    }
}
