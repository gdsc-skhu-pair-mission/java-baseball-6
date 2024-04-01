package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.domain.Massage.*;

public class validator {

    public static void validateLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateRange(String input) {
        for (char num : input.toCharArray()) {
            String[] numbers = input.split("");
            for (String number : numbers) {
                if (Integer.parseInt(number) < MIN || Integer.parseInt(number) > MAX) {
                    throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
                }
            }
        }
    }

    public static void validateDuplicate(String input){
        String[] numbers = input.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}