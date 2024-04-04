package baseball.util;

public class Validator {

    public static void validateInputNumber(String input) {
        CustomException.validateNull(input);
        CustomException.validateDuplicate(input);
        CustomException.validateThreeDigit(input);
        CustomException.validateRange(input);
    }
}
