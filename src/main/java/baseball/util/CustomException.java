package baseball.util;

import static baseball.util.ErrorMessage.INPUT_NUMBER_DUPLICATE;
import static baseball.util.ErrorMessage.INPUT_NUMBER_NOT_3_DIGIT;
import static baseball.util.ErrorMessage.INPUT_NUMBER_NOT_NULL;
import static baseball.util.ErrorMessage.INPUT_NUMBER_NOT_RANGE;
import static baseball.util.ExceptionHandler.Exception;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomException extends Exception {

    private static final int INPUT_NUMBER_LENGTH = 3;

    private static boolean hasDuplicateNumber(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!characterSet.add(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRequirementNumber(String input) {
        return Pattern.matches("^[1-9]{3}$", input);
    }

    public static void validateNull(String input) {
        if (input == null) {
            Exception(INPUT_NUMBER_NOT_NULL);
        }
    }

    public static void validateDuplicate(String input) {
        if (hasDuplicateNumber(input)) {
            Exception(INPUT_NUMBER_DUPLICATE);
        }
    }

    public static void validateThreeDigit(String input) {
        if (input.length() != INPUT_NUMBER_LENGTH) {
            Exception(INPUT_NUMBER_NOT_3_DIGIT);
        }
    }

    public static void validateRange(String input) {
        if (!isRequirementNumber(input)) {
            Exception(INPUT_NUMBER_NOT_RANGE);
        }
    }

}
