package baseball.view;

public class OutputView {

    public void printResultMessage(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if (strike > 0 && ball > 0) {
            sb.append(ball).append("볼 ").append(strike).append("스트라이크");
        }
        if (strike > 0 && ball == 0) {
            sb.append(strike).append("스트라이크");
            if (strike == 3) {
                sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        if (strike == 0 && ball > 0) {
            sb.append(ball).append("볼");
        }
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

}