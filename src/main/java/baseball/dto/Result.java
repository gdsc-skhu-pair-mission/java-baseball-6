package baseball.dto;

public record Result(
        int strike,
        int ball
) {
    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
