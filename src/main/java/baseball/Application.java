package baseball;

import baseball.controller.NumberBaseballGameController;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        Computer computer = new Computer.Builder()
                .build();
        User user = new User.Builder()
                .build();

        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController(gameView,user,computer);

        numberBaseballGameController.numberBaseballGame();
    }

}
