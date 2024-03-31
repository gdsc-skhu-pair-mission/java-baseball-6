package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String getInputNumber() {
        String input = Console.readLine();
        return new Number(input);
    }
}
