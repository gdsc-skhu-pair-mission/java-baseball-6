package baseball.view;

import baseball.constant.GameRule;
import baseball.constant.ViewMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInputNumber() {
        System.out.print(ViewMessage.INPUT_NUMBER);

        return Console.readLine();
    }

    public static boolean isRestart() {
        System.out.println(ViewMessage.INPUT_RESTART);

        String input = Console.readLine();
        return input.equals(GameRule.RESTART);
    }

    private InputView() {

    }

}
