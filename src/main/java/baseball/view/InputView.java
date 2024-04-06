package baseball.view;

import baseball.constant.MessageConst;
import baseball.domain.RandomNumbers;
import camp.nextstep.edu.missionutils.Console;

import static baseball.validator.InputValidation.validateRestart;

public class InputView {
    public static RandomNumbers readNumbers() {
        System.out.println(MessageConst.INPUT);

        String input = Console.readLine();
        return new RandomNumbers(input);
    }

    public static String readRestartOrEnd() {
        System.out.println(MessageConst.RESTART_OR_END);

        String input = Console.readLine();
        validateRestart(input);
        return input;
    }

}
