package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String InputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void nothingMessage() {
        System.out.println("낫싱");
    }

    public void threeStrikeMessage() {
        System.out.println("3스트라이크\n"
                + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void nonThreeStrikeMessage(int strikeCount, int ballCount) {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
    public int gameRestartOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
