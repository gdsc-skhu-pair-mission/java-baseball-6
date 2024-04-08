package baseball.dto;

public class GameResultDto {

    private final int ballCount;
    private final int strikeCount;

    public GameResultDto(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public GameResultDto offerBallAndStrikeCount(int ballCount, int strikeCount) {
        return new GameResultDto(ballCount, strikeCount);
    }
}
