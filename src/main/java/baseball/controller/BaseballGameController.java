package baseball.controller;

import baseball.dto.Result;
import baseball.model.Computer;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        Computer computer = new Computer();

        inputView.printGameStart();

        while (true) {
            Numbers numbers = inputView.getInputNumber();

            Result result = computer.calculateScore(numbers.getNumbers());

            outputView.printResultMessage(result.strike(), result.ball());

            if (result.isGameOver()) {
                if (inputView.isRestart()) {
                    computer.generateUniqueRandomNumbers();
                    continue;
                }
                break;
            }
        }
    }
}
