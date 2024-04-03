package baseball.model;

import baseball.constant.GameRule;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Computer {

    private List<Integer> numbers;

    public Computer() {
        generateUniqueRandomNumbers();
    }

    public void generateUniqueRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < GameRule.NUMBERS_SIZE) {
            uniqueNumbers.add(Randoms.pickNumberInRange(GameRule.MIN_NUMBER, GameRule.MAX_NUMBER));
        }

        this.numbers = new ArrayList<>(uniqueNumbers);
    }

    public Result calculateScore(List<Integer> userNumbers) {
        int strike = countStrike(userNumbers);
        int ball = countBall(userNumbers) - strike;

        return new Result(strike, ball);
    }

    private int countStrike(List<Integer> userNumbers) {
        return (int) IntStream.range(0, GameRule.NUMBERS_SIZE)
                .filter(i -> Objects.equals(this.numbers.get(i), userNumbers.get(i)))
                .count();
    }


    private int countBall(List<Integer> userNumbers) {
        return countDuplicateNumber(this.numbers, userNumbers);
    }

    private int countDuplicateNumber(List<Integer> list1, List<Integer> list2) {
        int totalSize = list1.size() + list2.size();

        Set<Integer> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        return totalSize - set.size();
    }

    public boolean isInit() {
        return numbers != null;
    }

}
