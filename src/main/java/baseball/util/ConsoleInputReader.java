package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputReader implements InputReader {
    @Override
    public String readInput() {
        return Console.readLine();
    }
}
