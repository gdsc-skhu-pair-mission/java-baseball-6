package baseball;

import baseball.controller.NumberBaseballGameController;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameView;


public class Application {
    public static void main(String[] args) {
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        numberBaseballGameController.numberBaseballGame();
    }

}
