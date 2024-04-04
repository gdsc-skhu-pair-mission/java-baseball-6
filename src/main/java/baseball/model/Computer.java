package baseball.model;

import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.constant.GameRule.MAX_NUMBER;
import static baseball.constant.GameRule.MIN_NUMBER;
import static baseball.constant.GameRule.NUMBERS_SIZE;

public class Computer {

    private List<Integer> numbers;

    public Computer() {
        generateUniqueRandomNumbers();
    }

    public void generateUniqueRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }

        this.numbers = new ArrayList<>(uniqueNumbers);
    }

    public Result calculateScore(List<Integer> userNumbers) {
        int strike = countStrike(userNumbers);
        int ball = countBall(userNumbers) - strike;

        return new Result(strike, ball);
    }

    private int countStrike(List<Integer> userNumbers) {
        return (int) IntStream.range(0, NUMBERS_SIZE)
                .filter(i -> Objects.equals(this.numbers.get(i), userNumbers.get(i)))
                .count();
    }


    private int countBall(List<Integer> userNumbers) {
        return countDuplicateNumber(this.numbers, userNumbers);
    }

    // Set 자료구조를 사용해 중복되는 수의 개수를 반환하는 메서드
    private int countDuplicateNumber(List<Integer> list1, List<Integer> list2) {
        int totalSize = list1.size() + list2.size();

        Set<Integer> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        return totalSize - set.size();
    }

}
