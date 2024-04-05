package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.PlayerStatus;
import baseball.view.InputView;

public class GameRetryService {

    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;

    public void processNextGameStatus(Computer computer, Player player) {
        player.setRetryNumber(InputView.inputRetryNumber());
        setNextGameStatus(computer, player);
    }

    public void setNextGameStatus(Computer computer, Player player) {

        if (player.getRetryNumber() == RESTART_GAME) {
            computer.refreshGameNumber(); // 새로운 숫자로 갱신
        }

        if (player.getRetryNumber() == END_GAME) {
            player.setStatusEnd();
        }
    }
}
