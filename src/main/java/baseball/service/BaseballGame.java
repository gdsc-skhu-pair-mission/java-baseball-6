package baseball.service;

import static baseball.util.ErrorMessage.RESTART_INPUT_WRONG_NUMBER;
import static baseball.util.ExceptionHandler.CustomException;
import static baseball.view.InputView.printInputMessage;
import static baseball.view.InputView.printRestartMessage;
import static baseball.view.OutputView.printEndGameMessage;
import static baseball.view.OutputView.printResultMessage;
import static baseball.view.OutputView.printStartMessage;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.InputReader;
import java.util.List;

public class BaseballGame {

    private static final int RESTART_YES = 1;
    private static final int RESTART_NO = 2;

    private final InputReader inputReader;
    private final Computer computer;
    private final Player player;
    private final CountResult countResult;

    public BaseballGame(InputReader inputReader, Computer computer, Player player, CountResult countResult) {
        this.inputReader = inputReader;
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
            printInputMessage();
            playerNumber = player.inputPlayerNumber();

            int countStrikes = countResult.countStrikes(playerNumber, computerNumber);
            int countBalls = countResult.countBalls(playerNumber, computerNumber);

            printResultMessage(countStrikes, countBalls);
        } while (!countResult.judgementEndGame(playerNumber, computerNumber));

        printEndGameMessage();
    }

    public boolean askRestartGame() {
        printRestartMessage();
        String input = inputReader.readInput();

        try {
            int answerNumber = Integer.parseInt(input);

            if (answerNumber != RESTART_YES && answerNumber != RESTART_NO) {
                CustomException(RESTART_INPUT_WRONG_NUMBER);
            }

            return answerNumber == RESTART_YES;
        } catch (NumberFormatException e) {
            CustomException(RESTART_INPUT_WRONG_NUMBER);
            return false;
        }
    }
}