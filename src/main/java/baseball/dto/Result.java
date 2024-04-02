package baseball.dto;

public record Result(
        int strike,
        int ball
) {
    public boolean isGameOver() {
        return this.strike == 3;
    }
}
