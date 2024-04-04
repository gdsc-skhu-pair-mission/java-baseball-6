package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringInterConverter {

    public static List<Integer> convertStringToIntegers(final String input) {
        return new ArrayList<>(input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList());
    }
}
