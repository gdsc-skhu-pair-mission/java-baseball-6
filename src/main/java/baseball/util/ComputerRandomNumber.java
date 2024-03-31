package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
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
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }

        return computerRandomNumber;
    }
}
