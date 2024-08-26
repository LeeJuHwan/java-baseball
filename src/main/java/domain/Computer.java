package domain;

import static core.SystemConstant.*;
import java.util.ArrayList;
import java.util.Random;

public class Computer {

    public static final int BOUND = 9;
    private static final Random random = new Random();
    private final ArrayList<String> randomNumbers = new ArrayList<>();

    public ArrayList<String> readyToGameStart() {

        if (isGenerateRandomNumberSizeEqualToLimit()) {
            return randomNumbers;
        }
        String number = getRandomNumberToString();

        if (doesNotDuplicate(number)) {
            randomNumbers.add(number);
        }
        return readyToGameStart();
    }

    private boolean isGenerateRandomNumberSizeEqualToLimit() {
        return randomNumbers.size() == INPUT_LIMIT_LENGTH;
    }

    private String getRandomNumberToString() {
        return String.valueOf(random.nextInt(BOUND) + 1);
    }

    private boolean doesNotDuplicate(String compareInteger) {
        return !randomNumbers.contains(compareInteger);
    }
}
