package baseball.util;

import baseball.dto.GameResultDto;


public class PlayerHint {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTTING = "낫싱";

    private String playerHint;

    public String calculateHint(GameResultDto countDto) {
        int ballCount = countDto.getBallCount();
        int strikeCount = countDto.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            return NOTTING;
        }

        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + STRIKE;
        }

        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + BALL;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    public void setPlayerHint(String hint) {
        this.playerHint = hint;
    }

    public String getPlayerHint() {
        return playerHint;
    }
}
