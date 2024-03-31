package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {
    private final List<Integer> number;

    public Number() {
        GenerateRandomNumber generateRandomNumbers = new GenerateRandomNumber();
        this.number = generateRandomNumbers.generate();
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    private boolean isNaturalNumber(String inputNumber) {
        for (char c : inputNumber.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeDigitNumber(String inputNumber) {
        return inputNumber.length() == 3;
    }

    private boolean isDuplicate(String inputNumber) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            set.add(inputNumber.charAt(i));
        }

        return set.size() == 3;
    }


    // 3자리 수가 아닌 경우

    // 1~9까지 숫자가 아닌 경우

    //중복된 값이 존재하는 경우

    // 종료 메시지 입력 오류
}
