package baseball.view;

public final class Message {

    public final static Integer RESTART = 1;

    public final static Integer END = 2;

    public final static String START = "숫자 야구 게임을 시작합니다.";

    public final static String INPUT = "숫자를 입력해주세요 : ";

    public final static String BALL = "%d볼";

    public final static String STRIKE = "%d스트라이크";

    public final static String NOTHING = "낫싱";

    public final static String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public final static String RESTART_OR_END = "게임을 새로 시작하려면 " + RESTART +
            ", 종료하려면 " + END + "를 입력하세요.";


}
