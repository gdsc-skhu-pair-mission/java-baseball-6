package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static String inputPlayerNumber() {
        printInputMessage();
        return Console.readLine();
    }

    public static String inputRestartNumber() {
        printRestartGameMessage();
        return Console.readLine();
    }
}
