package baseball.domain;

import static baseball.util.InputNumberValidator.validateInputNumber;


public class Player {

    private int retryNumber;
    private String playerNumber;
    private PlayerStatus playerStatus;


    public Player() {
        this.playerStatus = PlayerStatus.CREATE;
    }

    public Player(String playerNumber) {
        validateInputNumber(playerNumber);
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

    public void setStatusEnd() {
        this.playerStatus = PlayerStatus.END;
    }
}
