package baseball.util;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputNumberValidator {

    private InputNumberValidator() {
        throw new AssertionError("유틸리티 클래스는 인스턴스화 될 수 없습니다.");
    }

    public static void validateInputNumber(String inputNumber) {
        checkThreeDigitInput(inputNumber);
        isDigitPlayerNumber(inputNumber);
        isDifferentPlayerNumber(inputNumber);
    }

    // 예외처리 ex. 세 자리 수 입력 x
    private static void checkThreeDigitInput(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. => 3자리 자연수를 입력해주세요.");
        }
    }

    private static void isDigitPlayerNumber(String inputNumber){
        IntStream.range(0, inputNumber.length()) // -1?
                .forEach(place -> isDigitCharInString(inputNumber, place));
    }

    private static void isDigitCharInString(String inputNumber, int index) {
        if (!Character.isDigit(inputNumber.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. => 자연수가 아닌 수가 있습니다.");
        }
    }

    private static void isDifferentPlayerNumber(String inputNumber) {
        Set<Character> set = IntStream.range(0, inputNumber.length())
                .mapToObj(inputNumber::charAt)
                .collect(Collectors.toSet());

        if (set.size() != inputNumber.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. => 중복된 수가 존재합니다. ");
        }
    }
}