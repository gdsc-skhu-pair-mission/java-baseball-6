package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {

    public final static Integer INPUT_LENGTH = 3;

    public final static Integer MIN = 1;

    public final static Integer MAX = 9;

    public List<Integer> generate() {
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