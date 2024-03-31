package baseball.util;

import java.util.List;

public class PlayerHint {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTTING = "낫싱";
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    private static String playerHint;

    public void offerResultHint(List<Integer> ballAndStrikeCount) {
        int ballCount = ballAndStrikeCount.get(BALL_INDEX);
        int strikeCount = ballAndStrikeCount.get(STRIKE_INDEX);

        if (ballCount == 0 && strikeCount == 0) {
            this.playerHint = NOTTING;
            return;
        }

        if (ballCount == 0 && strikeCount != 0) {
            this.playerHint = strikeCount + STRIKE;
            return;
        }

        if (ballCount != 0 && strikeCount == 0) {
            this.playerHint = ballCount + BALL;
            return;
        }

        this.playerHint = ballCount + BALL + " " + strikeCount + STRIKE;
    }

    public static String getPlayerHint() {
        return playerHint;
    }
}
