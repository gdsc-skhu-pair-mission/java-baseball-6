package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.validator.validator.*;


public class Numbers {
    private List<Integer> numbers;

    public Numbers() {
        GenerateRandomNumber generateRandomNumbers = new GenerateRandomNumber();
        this.numbers = generateRandomNumbers.generate();
    }

    public Numbers(String input) {
        validateLength(input);
        validateRange(input);
        validateDuplicate(input);

        this.numbers = transformInputNumbers(input);
    }

    private List<Integer> transformInputNumbers(String input) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }

<<<<<<< HEAD
    private boolean isContainNumber(int number, int position) {
        return position != numbers.indexOf(number) && numbers.contains(number);
=======
    private boolean iscontainNumber(int number, int position) {
        return position != numbers.indexOf(number) && numbers.contains(number) ;
>>>>>>> 58c16cfaf53fe709d8d69771a43d71aa76b1fe73
    }

    private boolean isSamePosition(int number, int position) {
        return position == numbers.indexOf(number);
    }

    private int countBall(Numbers inputNumbers) {
        int ball = 0;
        for(int i = 0; i < numbers.size(); i++) {
            if(inputNumbers.isContainNumber(numbers.get(i),i)) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(Numbers inputNumbers) {
        int strike = 0;
        for(int i = 0; i < numbers.size(); i++) {
            if (inputNumbers.isSamePosition(numbers.get(i), i)) {
                strike++;
            }
        }
         return strike;
    }

    public Result compareToNumbers(Numbers inputNumbers) {
        return new Result(countBall(inputNumbers), countStrike(inputNumbers));
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
