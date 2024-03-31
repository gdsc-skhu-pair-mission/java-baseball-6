package baseball.view;

public class OutputView {
    
    private static final String GAME_START_PRINT = "숫자 야구 게임을 시작합니다.";
    private static final String ALL_STRIKE_PRINT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_PRINT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_PRINT = "스트라이크";

    public void printNoneStrikeResult(String notStrikeHint) {
        System.out.println(notStrikeHint);
    }

    public void printAllStrikeResult(int strikeCount) {
        System.out.println(strikeCount + STRIKE_PRINT);
        System.out.println(ALL_STRIKE_PRINT);
        System.out.println(RESTART_PRINT);
    }

    public void printCreateController() {
        System.out.println(GAME_START_PRINT);
    }
}
