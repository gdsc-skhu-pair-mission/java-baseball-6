package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class DefaultNumberConverter implements NumberConverter {
    @Override
    public List<Integer> convertStringToIntegers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}
