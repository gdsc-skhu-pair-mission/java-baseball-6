package baseball.view;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Console;

import static baseball.controller.Validator.validateRestart;

public class Input {

    public static Numbers readNumbers() {
        Output.inputMessage();

        String input = Console.readLine();
        return new Numbers(input);
    }

    public static String readRestartOrEnd() {
        Output.RestartOrEndMessage();

        String input = Console.readLine();
        validateRestart(input);
        return input;
    }
}
