package baseball.domain;

import java.util.stream.IntStream;

public class Player {

    private int retryNumber;
    private String playerNumber;
    private PlayerStatus playerStatus;


    public Player() {
        this.playerStatus = PlayerStatus.CREATE;
    }

    public Player(String playerNumber) {
        checkThreeDigitInput(playerNumber);
        validatePlayerNumberFormat(playerNumber);
        isDifferentPlayerNumber(playerNumber);
        this.playerStatus = PlayerStatus.PROCEEDING;
        this.playerNumber = playerNumber;
    }

    public Player(int retryNumber) {
        this.retryNumber = retryNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setRetryNumber(int retryNumber) {
        this.retryNumber = retryNumber;
    }

    public int getRetryNumber() {
        return retryNumber;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    // 예외처리 ex. 세 자리 수 입력 x
    public static void checkThreeDigitInput(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. => 3자리 자연수를 입력해주세요.");
        }
    }

    public static void validatePlayerNumberFormat(String inputNumber){
        IntStream.range(0, inputNumber.length()) // -1?
                .forEach(place -> isDigitCharInString(inputNumber, place));
    }

    public static void isDigitCharInString(String inputNumber, int index) {
        if (!Character.isDigit(inputNumber.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. => 자연수가 아닌 수가 있습니다.");
        }
    }

    public static void isDifferentPlayerNumber(String inputNumber) {
        char firstDigit = inputNumber.charAt(0);
        char secondDigit = inputNumber.charAt(1);
        char thirdDigit = inputNumber.charAt(2);

        if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. => 세 자리 모두 서로 다른 수여야 합니다.");
        }
    }
}
