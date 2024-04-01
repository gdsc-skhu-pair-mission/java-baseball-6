package baseball.view;

import baseball.domain.Result;

import java.util.ArrayList;

import static baseball.domain.Massage.*;

public class Output{
    public static void startMessage() {
        System.out.println(START);
    }

    public static void inputMessage() {
        System.out.println(INPUT);
    }

    public static void successMassage() {
        System.out.println(SUCCESS);
    }
    public static void resultOrEndMessage() {
        System.out.println(RESTART_OR_END);
    }

    public static void resultMessage(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

<<<<<<< HEAD
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
=======
        ArrayList<String> results = new ArrayList<>();
        if (ballCount != 0)
            results.add(String.format(BALL, ballCount));
        if (strikeCount != 0)
            results.add(String.format(STRIKE, strikeCount));
        if (ballCount == 0 && strikeCount == 0)
            results.add(String.format(NOTHING));

        System.out.println(String.join(" ",results));
>>>>>>> 58c16cfaf53fe709d8d69771a43d71aa76b1fe73
    }

}
