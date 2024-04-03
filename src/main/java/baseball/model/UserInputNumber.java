package baseball.model;

import baseball.exception.ErrorMessage;
import baseball.exception.WrongInputException;
import java.util.Arrays;
import java.util.List;

public class UserInputNumber implements Input {

    private final List<Integer> numbers;

    public UserInputNumber(String input) {
        checkAllException(input);
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
        if (input.length() != 3) throw new WrongInputException(ErrorMessage.INVALID_LENGTH.getMessage());
    }

    public void checkIsDistinctInput(String input) {
        if (!isDistinct(input)) throw new WrongInputException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    public void checkInputIsNumbers(String input) {
        if (!input.matches("[0-9]+")) throw new WrongInputException(ErrorMessage.NOT_NUMERIC.getMessage());
    }

    private static boolean isDistinct(String input) {
        if (input.charAt(0) == input.charAt(1)) return false;
        if (input.charAt(1) == input.charAt(2)) return false;
        return input.charAt(2) != input.charAt(0);
    }

    public List<Integer> stringToArrayList(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
        return numbers;
    }

}
