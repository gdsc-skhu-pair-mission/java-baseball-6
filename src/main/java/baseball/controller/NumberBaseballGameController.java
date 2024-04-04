package baseball.controller;

import baseball.exception.ErrorMessage;
import baseball.exception.WrongInputException;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberBaseballGameController {
    // private final GameView gameview = new GameView();
    private final GameView gameview;

    // private final User user = new User();
    private final User user;
    // private final Computer computer = new Computer();
    private final Computer computer;

    public NumberBaseballGameController(GameView gameview, User user, Computer computer) {
        this.gameview = gameview;
        this.user = user;
        this.computer = computer;

    }
    private final int BALL_MAX_SIZE = 3;

    public void randomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BALL_MAX_SIZE) {
            int computerNumber = genereateRandomNumber();
            containCheck(computerNumbers, computerNumber);
        }
        computer.setComputerNumbers(computerNumbers);
    }

    private static void containCheck(List<Integer> computerNumbers, int computerNumber) {
        if (!computerNumbers.contains(computerNumber)) {
            computerNumbers.add(computerNumber);
        }
    }

    public int genereateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void inputUserNumber() {
        String input = gameview.InputNumbers();

        try {
            isException(input);

            // 입력값이 중복된 숫자를 포함한 경우 예외 발생
            if (!isDistinct(input)) {
                throw new WrongInputException(ErrorMessage.DUPLICATE_DIGITS);
            }

            List<Integer> userNumbers = new ArrayList<>();
            for (int i = 0; i < BALL_MAX_SIZE; i++) {
                userNumbers.add(Character.getNumericValue(input.charAt(i)));
            }
            user.setNumbers(userNumbers);

        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void isException(String input) {
        // 입력값이 3자리 숫자가 아닌 경우 예외 발생
        if (input.length() != 3 || !input.matches("\\d{3}")) {
            throw new WrongInputException(ErrorMessage.INVALID_LENGTH);
        }

        // 입력값이 숫자가 아닌 경우 예외 발생
        if (!input.matches("[0-9]+")) {
            throw new WrongInputException(ErrorMessage.NOT_NUMERIC);
        }
    }


    private boolean isDistinct(String input) {
        if (input.charAt(0) == input.charAt(1)) return false;
        if (input.charAt(1) == input.charAt(2)) return false;
        return input.charAt(2) != input.charAt(0);
    }


    public void compareNumber() {
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getComputerNumbers();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(userNumbers.get(i))) {
                ballCount++;
            }
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
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

    public void numberBaseballGame() {
        gameview.gameStartMessage();
        randomNumber();
        inputUserNumber();
        compareNumber();
    }

    public void gameRestartOrEnd() {
        int selectNumber = gameview.gameRestartOrEndMessage();
        if (selectNumber == 1) numberBaseballGame();
    }
}
