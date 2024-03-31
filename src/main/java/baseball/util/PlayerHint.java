package baseball.util;

import java.util.List;

public class PlayerHint {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTTING = "낫싱";

    private static String playerHint;

    public String offerResultHint(List<Integer> ballAndStrikeCount) {
        int ballCount = ballAndStrikeCount.get(0);
        int strikeCount = ballAndStrikeCount.get(1);

        if (ballCount == 0 && strikeCount == 0) {
            return NOTTING;
        }

        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + STRIKE;
        }

        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + BALL;
        }

        this.playerHint = ballCount + BALL + " " + strikeCount + STRIKE;
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    public static String getPlayerHint() {
        return playerHint;
    }
}
