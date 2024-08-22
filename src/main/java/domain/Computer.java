package domain;

import static core.SystemConstant.*;
import java.util.ArrayList;
import java.util.Random;

public class Computer {

    private final Random random = new Random();
    private final ArrayList<String> randomNumbers = new ArrayList<>();

    public ArrayList<String> generateRandomNumber() {
        if (randomNumbers.size() == INPUT_LIMIT_LENGTH) {
            return randomNumbers;
        }
        String number = getRandomNumberToString();

        if (doesNotDuplicate(number)) {
            randomNumbers.add(number);
        }
        return generateRandomNumber();
    }

    private String getRandomNumberToString() {
        return String.valueOf(random.nextInt(9) + 1);
    }

    private boolean doesNotDuplicate(String compareInteger) {
        return !randomNumbers.contains(compareInteger);
    }
}
