package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int INPUT_LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    public List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
