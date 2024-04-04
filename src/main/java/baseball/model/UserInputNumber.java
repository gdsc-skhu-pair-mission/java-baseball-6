package baseball.model;

import baseball.controller.NumberBaseballGameController;
import baseball.exception.ErrorMessage;
import baseball.exception.WrongInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputNumber {

    private static UserInputNumber instance;
    private List<Integer> numbers;

    public static UserInputNumber getInstance() {
        if (instance == null) {
            instance = new UserInputNumber();
        }
        return instance;
    }

    public void setUserInputNumber(String input) {
        this.numbers = stringToArrayList(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void checkAllException(String input) {
        checkIsCorrectInput(input);
        checkIsDistinctInput(input);
        checkInputIsNumbers(input);
    }

    public void checkIsCorrectInput(String input) {
        if (input.length() != 3) {
            throw new WrongInputException(ErrorMessage.INVALID_LENGTH.getMessage());
        }
    }

    public void checkIsDistinctInput(String input) {
        if (!isDistinct(input)) {
            throw new WrongInputException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public void checkInputIsNumbers(String input) {
        if (!input.matches("[0-9]+")) {
            throw new WrongInputException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    private static boolean isDistinct(String input) {
        if (input.charAt(0) == input.charAt(1)) {
            return false;
        }
        if (input.charAt(1) == input.charAt(2)) {
            return false;
        }
        return input.charAt(2) != input.charAt(0);
    }

    public static List<Integer> stringToArrayList(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
        return numbers;
    }

}
