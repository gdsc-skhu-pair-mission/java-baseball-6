package baseball.view;

import baseball.domain.Result;

import java.util.ArrayList;

import static baseball.domain.Massage.*;

public class Output{
    public static void startMassage() {
        System.out.println(START);
    }

    public static void inputMassage() {
        System.out.println(INPUT);
    }

    public static void successMassage() {
        System.out.println(SUCCESS);
        System.out.println(RESTART_OR_END);
    }

    public static void result(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        ArrayList<String> gameResult = new ArrayList<>();
        if (ballCount != 0) {
            gameResult.add(String.format(BALL, ballCount));
        } else if (strikeCount != 0) {
            gameResult.add(String.format(STRIKE, strikeCount));
        } else if (ballCount == 0 && strikeCount == 0) {
            gameResult.add(String.format(NOTHING));
        }
        System.out.println(String.join(" ",gameResult));
    }

}
