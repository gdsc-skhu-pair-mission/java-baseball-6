package baseball;


import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.BaseballGame;
import baseball.service.CountResult;
import baseball.util.ConsoleInputReader;
import baseball.util.DefaultNumberConverter;
import baseball.util.InputReader;
import baseball.util.NumberConverter;


public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        NumberConverter numberConverter = new DefaultNumberConverter();
        BaseballGame baseballGame = new BaseballGame(inputReader, new Computer(), new Player(inputReader, numberConverter), new CountResult());
        baseballGame.playGame();
    }
}