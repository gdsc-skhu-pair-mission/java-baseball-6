package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static Computer instance;
    private List<Integer> randomNumbers;

    public static Computer getInstance() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }

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
