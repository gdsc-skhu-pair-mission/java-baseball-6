package baseball.controller;

import static baseball.util.ErrorMessage.RESTART_INPUT_WRONG_NUMBER;
import static baseball.util.ExceptionHandler.Exception;
import static baseball.view.InputView.inputPlayerNumber;
import static baseball.view.InputView.inputRestartNumber;
import static baseball.view.OutputView.printEndGameMessage;
import static baseball.view.OutputView.printResultMessage;
import static baseball.view.OutputView.printStartMessage;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.CountResult;
import java.util.List;

public class BaseballGame {

    private static final int RESTART_YES = 1;
    private static final int RESTART_NO = 2;

    private final Computer computer;
    private final Player player;
    private final CountResult countResult;

    public BaseballGame(Computer computer, Player player, CountResult countResult) {
        this.computer = computer;
        this.player = player;
        this.countResult = countResult;
    }

    public void playGame() {
        do {
            printStartMessage();
            processGame();
        } while (askRestartGame());
    }

    public void processGame() {
        List<Integer> computerNumber = computer.generateRandomNumber();
        List<Integer> playerNumber;
        do {
            playerNumber = player.filteredPlayerNumber(inputPlayerNumber());

            int countStrikes = countResult.countStrikes(playerNumber, computerNumber);
            int countBalls = countResult.countBalls(playerNumber, computerNumber);

            printResultMessage(countStrikes, countBalls);
        } while (!countResult.judgementEndGame(playerNumber, computerNumber));

        printEndGameMessage();
    }

    public boolean askRestartGame() {
        int answerNumber = Integer.parseInt(inputRestartNumber());
        if (answerNumber != RESTART_YES && answerNumber != RESTART_NO) {
            Exception(RESTART_INPUT_WRONG_NUMBER);
        }
        return answerNumber == RESTART_YES;
    }
}