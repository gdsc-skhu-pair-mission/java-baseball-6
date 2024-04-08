package baseball.view;

import baseball.constant.MessageConst;
import baseball.domain.Result;

import java.util.ArrayList;

import static baseball.constant.MessageConst.*;

public class OutputView {

    public static void startMessage() {
        System.out.println(MessageConst.START);
    }

    public static void successMessage() {
        System.out.println(SUCCESS);
    }

    public static void resultMessage(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        ArrayList<String> gameResult = new ArrayList<>();
        if (ballCount != 0) {
            gameResult.add(String.format(BALL, ballCount));
        }
        if (strikeCount != 0) {
            gameResult.add(String.format(STRIKE, strikeCount));
        }
        if (ballCount == 0 && strikeCount == 0) {
            gameResult.add(String.format(NOTHING));
        }

        System.out.println(String.join(" ",gameResult));
    }

}
