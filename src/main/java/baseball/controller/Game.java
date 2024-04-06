package baseball.controller;

import baseball.domain.RandomNumbers;
import baseball.domain.Result;
import baseball.validator.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

import static baseball.constant.MessageConst.RESTART;
import static baseball.view.OutputView.startMessage;

public class Game {
    private RandomNumbers computerNumbers;

    public void gameStart() {
        startMessage();
        do {
            initComputerNumbers();
            game();
        } while (restart());
    }

    private void initComputerNumbers() {
        computerNumbers = new RandomNumbers();
    }

    private void game() {
        Result result = null;
        do {
            try {
                RandomNumbers playerNumbers = InputView.readNumbers();
                result = playerNumbers.compareResult(computerNumbers);
                OutputView.resultMessage(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (result == null || !result.isSuccess());
        OutputView.successMessage();
    }


    private boolean restart() {
        try {
            String input = InputView.readRestartOrEnd();
            InputValidation.validateRestart(input);
            return Objects.equals(input, RESTART);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}