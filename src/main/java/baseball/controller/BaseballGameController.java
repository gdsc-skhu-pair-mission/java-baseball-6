package baseball.controller;

import baseball.dto.Result;
import baseball.model.Computer;
import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public BaseballGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.computer = new Computer();
    }

    public void start() {
        System.out.println(computer.getNumber().toString());

        inputView.printGameStart();

        while (true) {
            Number number = inputView.getInputNumber();

            Result result = compare(number.getNumber(), computer.getNumber());

            outputView.printResultMessage(result.strike(), result.ball());

            // TODO: 재시작 로직 구현
            if (result.strike() == 3) {
                break;
            }
        }

    }

    private Result compare(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = countStrike(userNumber, computerNumber);
        int ball = countBall(userNumber, computerNumber) - strike;

        return new Result(strike, ball);
    }

    private Integer countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(userNumber.get(i), computerNumber.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    private Integer countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        Set<Integer> set = new HashSet<>();
        set.addAll(userNumber);
        set.addAll(computerNumber);

        return 6 - set.size();
    }
}
