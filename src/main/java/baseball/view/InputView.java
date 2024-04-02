package baseball.view;

import baseball.model.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public Numbers getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return new Numbers(input);
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equals("1");
    }
}
