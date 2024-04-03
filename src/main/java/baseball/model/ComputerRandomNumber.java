package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerRandomNumber implements Computer {

    private List<Integer> randomNumbers;

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void generateRandomComputerNumbers() {
        Set<Integer> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumbers.add(randomNumber);
        }
        this.randomNumbers = new ArrayList<>(computerNumbers);
    }
}
