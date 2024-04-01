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
            int number = Character.getNumericValue(num);
            if (number< MIN || number > MAX) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }
    public static void validateDuplicate (String input){
        Set<Character> numberSet = new HashSet<>();
        for (char number : input.toCharArray()) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
            }
        }

    }
}