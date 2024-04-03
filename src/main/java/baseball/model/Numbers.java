package baseball.model;

import baseball.constant.GameRule;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(String inputNumbers) {
        checkInputIsNull(inputNumbers);
        checkThreeDigitNumber(inputNumbers);
        checkNaturalNumber(inputNumbers);
        checkDuplicate(inputNumbers);

        this.numbers = inputNumbersToList(inputNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void checkInputIsNull(String input) {
        if (input == null) {
            throw new IllegalStateException("잘못된 인자를 전달받았습니다.");
        }
    }

    private static void checkThreeDigitNumber(String inputNumbers) {
        if (inputNumbers.length() != GameRule.NUMBERS_SIZE) {
            throw new IllegalArgumentException("3자리수를 입력해주세요.");
        }
    }

    private static void checkNaturalNumber(String inputNumbers) {
        if (!inputNumbers.matches(GameRule.NUMBER_RANGE_REGEX)) {
            throw new IllegalArgumentException("1부터 9까지의 자연수를 입력해주세요.");
        }
    }

    private static void checkDuplicate(String input) {
        long distinctCount = input.chars()
                .distinct()
                .count();

        if (input.length() != distinctCount) {
            throw new IllegalArgumentException("중복되지 않는 수를 입력해주세요.");
        }
    }

    private List<Integer> inputNumbersToList(String inputNumbers) {
        return inputNumbers.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> (Character.digit(c, 10)))
                .toList();
    }

}
