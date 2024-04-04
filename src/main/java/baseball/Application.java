package baseball;


import baseball.model.Computer;
import baseball.model.Player;
import baseball.controller.BaseballGame;
import baseball.service.CountResult;


public class Application {
    public static void main(String[] args) {
        new BaseballGame(new Computer(), new Player(), new CountResult()).playGame();
    }
}
