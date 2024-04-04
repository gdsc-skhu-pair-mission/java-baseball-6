package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ComputerRandomNumber {

    private String computerNumber;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_NUMBER_LENGTH = 3;

    public String getComputerNumber() {
        return computerNumber;
    }

    public ComputerRandomNumber(List<Integer> computerNumberList) {
        this.computerNumber = computerNumberListToString(computerNumberList);
    }

    public ComputerRandomNumber() {
        this.computerNumber = computerNumberListToString(getRandomNumberList());
    }

    public String computerNumberListToString(List<Integer> computerGameNumberList) {

        return computerGameNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static List<Integer> getRandomNumberList() {
        // O(1) 시간 복잡도 재구현 => HashSet 사용, 중복 불허
        Set<Integer> numbersSet = new HashSet<>();
        while (numbersSet.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            // contains => O(n), 제거
            numbersSet.add(randomNumber);
        }

        // 순서가 있기에 List로 변환
        List<Integer> computerRandomNumber = new ArrayList<>(numbersSet);

        return computerRandomNumber;
    }
}
