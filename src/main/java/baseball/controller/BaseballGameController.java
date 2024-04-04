package baseball.controller;

import baseball.constant.GameRule;
import baseball.dto.Result;
import baseball.model.Computer;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    public void start() {
        Computer computer = new Computer();
        isReady(computer);

        boolean isNotEnded = true;
        while (isNotEnded) {
            game(computer);

            isNotEnded = askRestart(computer);
        }
    }

    private void game(Computer computer) {
        boolean isEnd = false;

        while (!isEnd) {
            String input = InputView.getInputNumber();
            Numbers numbers = new Numbers(input);

            Result result = computer.calculateScore(numbers.getNumbers());
            OutputView.printResultMessage(result.strike(), result.ball());

            isEnd = isGameEnd(result);
        }
    }

    private boolean askRestart(Computer computer) {
        if (InputView.isRestart()) {
            computer.generateUniqueRandomNumbers();
            return true;
        }

        return false;
    }

    private void isReady(Computer computer) {
        if (computer.isInit()) {
            OutputView.printGameStart();
            return;
        }

        throw new IllegalStateException("컴퓨터 생성에 오류가 생겼습니다.");
    }

    private boolean isGameEnd(Result result) {
        return result.strike() == GameRule.NUMBERS_SIZE;
    }

}
