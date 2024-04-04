package baseball.view;

public class OutputView {

    private static final String OUTPUT_BALL_MESSAGE = "볼 ";
    private static final String OUTPUT_STRIKE_MESSAGE = "스트라이크";
    private static final String OUTPUT_NOTHING_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 볼, 스트라이크, 낫싱을 출력한다.
     *
     * @param strikes 스트라이크 수
     * @param balls   볼 수
     */
    public static void printResultMessage(int strikes, int balls) {
        StringBuilder resultMessage = new StringBuilder();

        if (balls > 0) {
            resultMessage.append(balls).append(OUTPUT_BALL_MESSAGE);
        }
        if (strikes > 0) {
            resultMessage.append(strikes).append(OUTPUT_STRIKE_MESSAGE);
        }
        if (strikes == 0 && balls == 0) {
            resultMessage.append(OUTPUT_NOTHING_MESSAGE);
        }

        System.out.println(resultMessage.toString());
    }
}