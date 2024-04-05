package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.PlayerStatus;
import baseball.dto.GameResultDto;
import baseball.service.GameNumberValidateService;
import baseball.service.GameRetryService;
import baseball.util.ComputerRandomNumber;
import baseball.util.PlayerHint;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GamePlayController {

    private static final int ALL_STRIKE = 3;
    private static final String STRIKE_PRINT = "스트라이크";

    private Computer computer;
    private Player player;

    private GameResultDto resultDto;

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
            this.inputPlayerNumber();
            resultDto = ballAndStrikeCount(computer.getComputerGameNumber(), player.getPlayerNumber());
            printHintResult(resultDto);
            allStrikeGameExit();
        }
    }

    private void inputPlayerNumber() {
        player = new Player(InputView.setPlayerNumber());
    }

    public GameResultDto ballAndStrikeCount(String computerNumber, String playerNumber) {

        return gameNumberValidateService.calculateGameNumber(computerNumber, playerNumber);
    }

    public void printHintResult(GameResultDto resultDto) {

        String hint = playerHint.calculateHint(resultDto.offerBallAndStrikeCount(resultDto.getBallCount(), resultDto.getStrikeCount()));
        playerHint.setPlayerHint(hint);

        if (resultDto.getStrikeCount() == ALL_STRIKE) {
             outputView.printAllStrikeResult(ALL_STRIKE);
        }

        outputView.printNoneStrikeResult(playerHint.getPlayerHint());
    }

    private void allStrikeGameExit() {
        if (playerHint.getPlayerHint().equals(ALL_STRIKE + STRIKE_PRINT)) {
            gameRetryService.processNextGameStatus(computer, player);
        }
    }
}