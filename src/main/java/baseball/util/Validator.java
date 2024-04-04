package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.util.ExceptionHandler.CustomException;
import static baseball.util.ErrorMessage.*;

public class Validator {

    private static final int INPUT_NUMBER_LENGTH = 3;

    private static void checkedNullInputNumber(String input) {
        if (input == null) {
            CustomException(INPUT_NUMBER_NOT_NULL);
        }
    }

    private static void checkedLengthInputNumber(String input) {
        if (input.length() != INPUT_NUMBER_LENGTH) {
            CustomException(INPUT_NUMBER_NOT_3_DIGIT);
        }
    }

    private static boolean hasDuplicateNumber(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!characterSet.add(c)) {
                return true;
            }
        }
        return false;
    }

    private static void checkedDuplicateInputNumber(String input) {
        if (hasDuplicateNumber(input)) {
            CustomException(INPUT_NUMBER_DUPLICATE);
        }
    }
    private static boolean isRequirementNumber(String input) {
        return Pattern.matches("^[1-9]{3}$", input);
    }

    private static void checkedRequirementInputNumber(String input) {
        if (!isRequirementNumber(input)) {
            CustomException(INPUT_NUMBER_NOT_RANGE);
        }
    }

    public static void validateInputNumber(String input) {
        checkedNullInputNumber(input);
        checkedLengthInputNumber(input);
        checkedDuplicateInputNumber(input);
        checkedRequirementInputNumber(input);
    }

}
