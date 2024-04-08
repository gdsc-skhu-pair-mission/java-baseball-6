package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NUMBER_PRINT = "숫자를 입력해주세요 : ";
    private static final String WRONG_INPUT_NUMBER_PRINT = "잘못된 값을 입력했습니다. ";


    public static String setPlayerNumber() {
        System.out.print(INPUT_NUMBER_PRINT);
        return Console.readLine();
    }

    public static int inputRetryNumber() {
        String inputRetryNumber = Console.readLine();
        if (!inputRetryNumber.equals("1") && !inputRetryNumber.equals("2")) {
            throw new IllegalArgumentException(WRONG_INPUT_NUMBER_PRINT);
        }

        return Integer.parseInt(inputRetryNumber);
    }
}
