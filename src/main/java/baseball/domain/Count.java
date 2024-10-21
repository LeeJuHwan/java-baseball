package baseball.domain;

public enum Count {

    BALL("볼 카운트"),
    STRIKE("스트라이크 카운트"),
    NOTHING("낫띵");

    private String description;

    Count(String description) {
        this.description = description;
    }
}
