package baseball;

import baseball.controller.NumberBaseballGameController;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        User user = new User();
        Computer computer = new Computer();
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController(gameView,user,computer);

        numberBaseballGameController.numberBaseballGame();
    }

}
