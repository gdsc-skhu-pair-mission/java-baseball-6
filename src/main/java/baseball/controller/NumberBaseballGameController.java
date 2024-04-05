package baseball.controller;

import baseball.model.Computer;
import baseball.model.UserInputNumber;
import baseball.view.GameView;
import java.util.List;


public class NumberBaseballGameController {
    private final GameView gameview;
    private final Computer computer;
    private final UserInputNumber userInputNumber;

    public NumberBaseballGameController() {
        this.gameview = GameView.getInstance();
        this.computer = Computer.getInstance();
        this.userInputNumber = UserInputNumber.getInstance();
    }

    public void numberBaseballGame() {
        gameview.gameStartMessage();
        computer.generateRandomComputerNumbers();
        inputUserNumber();
        compareNumber();
    }

    private void inputUserNumber() {
        String input = gameview.inputNumbers();
        userInputNumber.setUserInputNumber(input);
    }

    private void compareNumber() {
        List<Integer> userNumbers = userInputNumber.getNumbers();
        List<Integer> computerNumbers = computer.getRandomNumbers();

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(userNumbers.get(i))) {
                ballCount++;
            }
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikeCount++;
            }
        }

        ballCount = ballCount - strikeCount;
        validateResult(strikeCount, ballCount);
    }

    public void validateResult(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            gameview.threeStrikeMessage();
            gameRestartOrEnd();
        } else if (ballCount == 0 && strikeCount == 0) {
            gameview.nothingMessage();
            inputUserNumber();
            compareNumber();
        } else {
            gameview.nonThreeStrikeMessage(strikeCount, ballCount);
            inputUserNumber();
            compareNumber();
        }
    }

    private void gameRestartOrEnd() {
        int selectNumber = gameview.gameRestartOrEndMessage();
        if (selectNumber == 1) {
            numberBaseballGame();
        }
    }
}
