package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.PlayerStatus;
import baseball.dto.BallAndStrikeCountDto;
import baseball.service.GameNumberValidateService;
import baseball.service.GameRetryService;
import baseball.util.ComputerRandomNumber;
import baseball.util.PlayerHint;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GamePlayController {

    private static final int ALL_STRIKE = 3;
    private static final String STRIKE_PRINT = "스트라이크";

    private static Computer computer;
    private static Player player;

    private BallAndStrikeCountDto resultDto;

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
            inputPlayerNumber();
            resultDto = ballAndStrikeCount(computer.getComputerGameNumber(), player.getPlayerNumber());
            offerRevisedHint(resultDto);
            allStrikeGameExit();
        }
    }

    private static void inputPlayerNumber() {
        player = new Player(InputView.setPlayerNumber());
    }

    public BallAndStrikeCountDto ballAndStrikeCount(String computerNumber, String playerNumber) {

        return gameNumberValidateService.calculateGameNumber(computerNumber, playerNumber);
    }

    public String offerRevisedHint(BallAndStrikeCountDto resultDto) {

        String hint = playerHint.offerResultHint(resultDto.offerBallAndStrikeCount(resultDto.getBallCount(), resultDto.getStrikeCount()));
        playerHint.setPlayerHint(hint);

        if (resultDto.getStrikeCount() == ALL_STRIKE) {
             return outputView.printAllStrikeResult(ALL_STRIKE);
        }

        return outputView.printNoneStrikeResult(playerHint.getPlayerHint());
    }

    private void allStrikeGameExit() {
        if (playerHint.getPlayerHint().equals(ALL_STRIKE + STRIKE_PRINT)) {
            gameRetryService.processNextGameStatus(computer, player);
        }
    }
}