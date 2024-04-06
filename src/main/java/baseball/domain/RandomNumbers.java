package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.validator.InputValidation.*;

public class RandomNumbers {
    private List<Integer> randomNumbers;

    public RandomNumbers() {
        Computer computer = new Computer();
        this.randomNumbers = computer.generateRandomNumber();
    }

    public RandomNumbers(String input) {
        validateLength(input);
        validateRangeNumber(input);
        validateRangeString(input);
        validateDuplicate(input);

        this.randomNumbers = transformInputNumbers(input);
    }

    private List<Integer> transformInputNumbers(String input) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }
    private boolean isContains(int number, int position) {
        return position != randomNumbers.indexOf(number) && randomNumbers.contains(number) ;

    }

    private boolean isSamePosition(int number, int position) {
        return position == randomNumbers.indexOf(number);
    }

    private int countBall(RandomNumbers inputRandomNumbers) {
        int ball = 0;
        for(int i = 0; i < randomNumbers.size(); i++) {
            if(inputRandomNumbers.isContains(randomNumbers.get(i),i)) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(RandomNumbers inputRandomNumbers) {
        int strike = 0;
        for(int i = 0; i < randomNumbers.size(); i++) {
            if (inputRandomNumbers.isSamePosition(randomNumbers.get(i), i)) {
                strike++;
            }
        }
        return strike;
    }

    public Result compareResult(RandomNumbers inputRandomNumbers) {
        return new Result(countBall(inputRandomNumbers), countStrike(inputRandomNumbers));
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + randomNumbers +
                '}';
    }


}