package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.GameRule.RESTART;
import static baseball.constant.ViewMessage.GAME_START;
import static baseball.constant.ViewMessage.INPUT_NUMBER;
import static baseball.constant.ViewMessage.INPUT_RESTART;

public class InputView {

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public String getInputNumber() {
        System.out.print(INPUT_NUMBER);

        return Console.readLine();
    }

    public boolean isRestart() {
        System.out.println(INPUT_RESTART);

        String input = Console.readLine();
        return input.equals(RESTART);
    }
}
