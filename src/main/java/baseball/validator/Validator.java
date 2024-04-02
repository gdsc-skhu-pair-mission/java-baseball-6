package baseball.validator;

import java.util.Arrays;

import static baseball.view.Message.*;

public class Validator {
    private final static int INPUT_LENGTH = 3;
    private final static int MIN = 1;
    private final static int MAX = 9;
    public final static String LENGTH_ERROR_MESSAGE = "3자리 수를 입력해야 합니다.";
    public final static String RANGE_ERROR_MESSAGE = "1과 9 사이의 숫자를 입력해야 합니다.";
    public final static String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 숫자를 입력해야 합니다.";

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