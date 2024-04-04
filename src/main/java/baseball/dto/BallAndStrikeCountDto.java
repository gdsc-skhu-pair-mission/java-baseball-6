package baseball.dto;

public class BallAndStrikeCountDto {

    private final int ballCount;
    private final int strikeCount;

    public BallAndStrikeCountDto(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public BallAndStrikeCountDto offerBallAndStrikeCount(int ballCount, int strikeCount) {
        return new BallAndStrikeCountDto(ballCount, strikeCount);
    }
}
