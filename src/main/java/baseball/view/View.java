package baseball.view;

public interface View {
    String inputNumbers();
    void gameStartMessage();
    void threeStrikeMessage();
    void nothingMessage();
    void nonThreeStrikeMessage(int strikeCount, int ballCount);
    int gameRestartOrEndMessage();
}
