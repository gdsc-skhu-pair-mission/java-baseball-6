package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.view.*;

import java.util.Objects;

import static baseball.view.Message.RESTART;

public class Game {
    private Numbers computerNumbers;

    public void gameStart() {
        do {
            initComputerNumbers();
            game();
        } while (restart());
    }

    private void initComputerNumbers() {
        computerNumbers = new Numbers();
    }


    private void game() {
        Result result;
        do {
            Numbers playerNumbers = Input.readNumbers();
            result = playerNumbers.compareToNumbers(computerNumbers);
            Output.resultMessage(result);
        } while (!result.isSuccess());
        Output.successMassage();
    }

    private boolean restart() {
        return Objects.equals(Input.readRestartOrEnd(), RESTART);
    }


}
