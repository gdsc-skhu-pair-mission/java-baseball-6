package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.PlayerStatus;
import baseball.service.GameNumberValidateService;
import baseball.service.GameRetryService;
import baseball.util.ComputerRandomNumber;
import baseball.util.PlayerHint;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GamePlayController {

    private static final int STRIKE = 1;
    private static final int ALL_STRIKE = 3;
    private static final String STRIKE_PRINT = "스트라이크";

    private static Computer computer;
    private static Player player;

    private final GameNumberValidateService gameNumberValidateService = new GameNumberValidateService();
    private final GameRetryService gameRetryService = new GameRetryService();
    private final PlayerHint playerHint = new PlayerHint();
    private final OutputView outputView = new OutputView();

    public GamePlayController() {
        outputView.printCreateController();
    }

    public void gameStart() {
        computer = new Computer(new ComputerRandomNumber());
        player = new Player();

        while (player.getPlayerStatus() != PlayerStatus.END) {
            inputPLayerNumber();
            hintResult(ballAndStrikeCount(computer.getComputerGameNumber(), player.getPlayerNumber()));
            allStrikeGameExit();
        }
    }

    private static void inputPLayerNumber() {
        player = new Player(InputView.setPlayerNumber());
    }

    public List<Integer> ballAndStrikeCount(String computerNumber, String playerNumber) {

        return gameNumberValidateService.calculateGameNumber(computerNumber, playerNumber);
    }

    public void hintResult(List<Integer> ballAndStrikeCountList) {
        playerHint.offerResultHint(ballAndStrikeCountList);

        if (ballAndStrikeCountList.get(STRIKE) == ALL_STRIKE) {
            outputView.printAllStrikeResult(ALL_STRIKE);
            return;
        }

        outputView.printNoneStrikeResult(playerHint.getPlayerHint());
    }

    private void allStrikeGameExit() {
        if (PlayerHint.getPlayerHint().equals(ALL_STRIKE + STRIKE_PRINT)) {
            gameRetryService.processNextGameStatus(computer, player);
        }
    }
}
