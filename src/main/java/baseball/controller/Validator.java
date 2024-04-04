package baseball.controller;

import java.util.Arrays;

import static baseball.model.GenerateRandomNumber.*;

public class Validator {
    public static final Integer MIN = 1;
    public static final Integer MAX = 9;

    public final static String LENGTH_ERROR_MESSAGE = "3자리 수를 입력해야 합니다.";
    public final static String RANGE_ERROR_MESSAGE = "1과 9 사이의 숫자를 입력해야 합니다.";
    public final static String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 숫자를 입력해야 합니다.";

    public final static String RESTART_ERROR_MESSAGE = "숫자 1 또는 2를 입력해야 합니다.";

    public static void validateLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateRangeNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            int num = Character.getNumericValue(digit);
            if (num < MIN || num > MAX) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static void validateRangeString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicate(String input) {
        if (isDuplicated(input)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
    public static boolean isDuplicated(String input) {
        String[] numbers = input.split("");
        return numbers.length != Arrays.stream(numbers).distinct().count();
    }

    public static void validateRestart(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
        }
    }
}