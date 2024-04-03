package baseball.view;

import baseball.dto.Result;

import static baseball.constant.ViewMessage.BALL;
import static baseball.constant.ViewMessage.GAME_END;
import static baseball.constant.ViewMessage.NOTHING;
import static baseball.constant.ViewMessage.STRIKE;
import static baseball.constant.ViewMessage.STRIKE_AND_BALL;

public class OutputView {

    public void printResultMessage(Result result) {
        int strike = result.strike();
        int ball = result.ball();

        System.out.println(getResultMessage(strike, ball));
    }

    public String getResultMessage(int strike, int ball) {
        if (strike == 3) {
            return GAME_END;
        }

        if (strike > 0 && ball == 0) {
            return String.format(STRIKE, strike);
        }

        if (strike == 0 && ball > 0) {
            return String.format(BALL, ball);
        }

        if (strike > 0 && ball > 0) {
            return String.format(STRIKE_AND_BALL, ball, strike);
        }

        return NOTHING;
    }

}