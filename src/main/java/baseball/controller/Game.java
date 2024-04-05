package baseball.controller;

import baseball.model.Numbers;
import baseball.model.Result;
import baseball.view.*;

import java.util.Objects;

import static baseball.view.Output.RESTART;
import static baseball.view.Output.startMessage;

public class Game {
    private Numbers computerNumbers;

    public void gameStart() {
        startMessage();
        do {
            initComputerNumbers();
            game();
        } while (restart());
    }

    private void initComputerNumbers() {
        computerNumbers = new Numbers();
    }

    private void game() {
        Result result = null;
        do {
            try {
                Numbers playerNumbers = Input.readNumbers();
                result = playerNumbers.compareToNumbers(computerNumbers);
                Output.resultMessage(result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (result == null || !result.isSuccess());
        Output.successMessage();
    }


    private boolean restart() {
        try {
            String input = Input.readRestartOrEnd();
            Validator.validateRestart(input);
            return Objects.equals(input, RESTART);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
