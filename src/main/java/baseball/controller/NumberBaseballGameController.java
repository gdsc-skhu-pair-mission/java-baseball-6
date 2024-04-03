package baseball.controller;

import baseball.model.Computer;
import baseball.model.ComputerRandomNumber;
import baseball.model.Input;
import baseball.model.UserInputNumber;
import baseball.view.GameView;
import baseball.view.View;
import java.util.List;


public class NumberBaseballGameController {
    private final View gameview;
    private final Computer computer;
    private Input userInputNumber;

    public NumberBaseballGameController() {
        this.gameview = new GameView();
        this.computer = new ComputerRandomNumber();
    }

    public void numberBaseballGame() {
        gameview.gameStartMessage();
        computer.generateRandomComputerNumbers();
        inputUserNumber();
        compareNumber();
    }

    private void inputUserNumber() {
        String input = gameview.inputNumbers();
        this.userInputNumber = new UserInputNumber(input);
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
        validateResult(strikeCount,ballCount);
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
        if (selectNumber == 1) numberBaseballGame();
    }
}
