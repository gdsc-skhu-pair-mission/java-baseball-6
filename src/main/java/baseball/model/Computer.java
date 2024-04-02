package baseball.model;

import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

public class Computer {

    private List<Integer> numbers;
    private static final int TOTAL_NUMBERS = 6;

    public Computer() {
        generateUniqueRandomNumbers();
    }

    public void generateUniqueRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 9));
        }

        this.numbers = new ArrayList<>(uniqueNumbers);
    }

    public Result calculateScore(List<Integer> userNumbers) {
        int strike = countStrike(userNumbers);
        int ball = countBall(userNumbers) - strike;

        return new Result(strike, ball);
    }

    private int countStrike(List<Integer> userNumbers) {
        return (int) IntStream.range(0, 3)
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
