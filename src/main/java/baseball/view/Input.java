package baseball.view;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static Numbers readNumbers() {
        Output.startMessage();
        Output.inputMessage();


        String input = Console.readLine();
        return new Numbers(input);
    }

    public static String readRestartOrEnd() {
        Output.successMassage();

        String input = Console.readLine();
        return input;
    }
}
