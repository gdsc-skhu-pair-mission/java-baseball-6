package baseball;

import baseball.model.Computer;
import baseball.model.Number;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        inputView.printGameStart();
        Number number = inputView.getInputNumber();
        Computer computer = new Computer();
    }
}
