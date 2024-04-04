package baseball.model;

import static baseball.util.StringInterConverter.convertStringToIntegers;

import baseball.util.Validator;
import java.util.List;

public class Player {

    public List<Integer> filteredPlayerNumber(String input) {
        Validator.validateInputNumber(input);
        List<Integer> numbers = convertStringToIntegers(input);
        return numbers;
    }

}