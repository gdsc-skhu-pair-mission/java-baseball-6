package baseball.model;

public class Result {

    private final int ballCount;
    private final int strikeCount;

    public Result(int ball, int strike) {
        this.ballCount = ball;
        this.strikeCount = strike;
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public String toString() {
        return "Result{" +
                "ballCount=" + ballCount +
                ", strikeCount=" + strikeCount +
                '}';
    }
}
