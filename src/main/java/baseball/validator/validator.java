package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.domain.Massage.*;

public class validator {
    private final static String LENGTH_ERROR_MESSAGE = "3자리 수를 입력해야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "1과 9 사이의 숫자를 입력해야 합니다.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 숫자를 입력해야 합니다.";

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