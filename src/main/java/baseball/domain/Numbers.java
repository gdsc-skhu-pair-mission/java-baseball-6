package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.validator.validator.*;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers() {
        GenerateRandomNumber generateRandomNumbers = new GenerateRandomNumber();
        this.numbers = generateRandomNumbers.generate();
    }

    public Numbers(String input) {
        validateLength(input);
        validateRange(input);
        validateDuplicate(input);

        this.numbers = transformInputNumbers(input);
    }

    private List<Integer> transformInputNumbers(String input) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }

}
