package baseball.model;

import static baseball.util.Validator.validateInputNumber;

import baseball.util.InputReader;
import baseball.util.NumberConverter;
import java.util.List;

public class Player {

    private final InputReader inputReader;
    private final NumberConverter numberConverter;

    public Player(InputReader inputReader, NumberConverter numberConverter) {
        this.inputReader = inputReader;
        this.numberConverter = numberConverter;
    }

    public List<Integer> inputPlayerNumber() {
        String input = inputReader.readInput();
        validateInputNumber(input);

        return numberConverter.convertStringToIntegers(input);
    }
}