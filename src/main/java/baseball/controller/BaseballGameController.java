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
            game(computer);

            if (!inputView.isRestart()) {
                break;
            }

            computer.generateUniqueRandomNumbers();
        }
    }

    private void game(Computer computer) {
        while (true) {
            String input = inputView.getInputNumber();
            Numbers numbers = new Numbers(input);

            Result result = computer.calculateScore(numbers.getNumbers());

            outputView.printResultMessage(result);

            if (result.isGameEnd()) {
                break;
            }
        }
    }
}
