package baseball.validator;

import java.util.Arrays;

public class InputValidation {
    private final static int INPUT_LENGTH = 3;
    private final static int MIN = 1;
    private final static int MAX = 9;
    private final static int RESTART = 1;
    private final static int END = 2;

    public final static String LENGTH_ERROR_MESSAGE = "3자리 수를 입력해야 합니다.";
    public final static String RANGE_ERROR_MESSAGE = "1과 9 사이의 숫자를 입력해야 합니다.";
    public final static String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 숫자를 입력해야 합니다.";
    public static final String RESTART_OR_END_MESSAGE= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";


    public static void validateLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateRangeNumber(String input) {
        for (char digit : input.toCharArray()) {
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
        if (!input.equals(String.valueOf(RESTART)) && !input.equals(String.valueOf(END))) {
            throw new IllegalArgumentException(RESTART_OR_END_MESSAGE);
        }
    }
}