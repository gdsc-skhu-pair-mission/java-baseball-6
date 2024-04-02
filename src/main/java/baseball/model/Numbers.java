package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("3자리수를 입력해주세요.");
        }
    }

    private static void checkNaturalNumber(String inputNumbers) {
        if (!inputNumbers.matches("[1-9]+")) {
            throw new IllegalArgumentException("1부터 9까지의 자연수를 입력해주세요.");
        }
    }

    private static void checkDuplicate(String input) {
        // Set 자료구조를 활용한 중복 확인
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        if (set.size() != input.length()) {
            throw new IllegalArgumentException("중복되지 않는 수를 입력해주세요.");
        }

        // GC가 처리하도록 명시적으로 null로 설정
        set = null;
    }

    private List<Integer> inputNumbersToList(String inputNumbers) {
        return inputNumbers.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> (Character.digit(c, 10)))
                .collect(Collectors.toList());
    }

}
