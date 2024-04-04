package baseball.view;

import baseball.constant.GameRule;
import baseball.constant.ViewMessage;

public class OutputView {

    public static void printGameStart() {
        System.out.println(ViewMessage.GAME_START);
    }

    public static void printResultMessage(int strike, int ball) {
        System.out.println(getResultMessage(strike, ball));
    }

    public static String getResultMessage(int strike, int ball) {
        if (strike == GameRule.NUMBERS_SIZE) {
            return ViewMessage.GAME_END;
        }

        if (strike > 0 && ball == 0) {
            return String.format(ViewMessage.STRIKE, strike);
        }

        if (strike == 0 && ball > 0) {
            return String.format(ViewMessage.BALL, ball);
        }

        if (strike > 0 && ball > 0) {
            return String.format(ViewMessage.STRIKE_AND_BALL, ball, strike);
        }

        return ViewMessage.NOTHING;
    }

    private OutputView() {

    }

}