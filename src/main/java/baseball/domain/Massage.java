package baseball.domain;

public final class Massage {

    public static final Integer RESTART = 1;

    public static final Integer END = 2;

    public static final String START = "숫자 야구 게임을 시작합니다.";

    public static final String INPUT = "숫자를 입력해주세요 : ";

    public static final String BALL = "%d볼";

    public static final String STRIKE = "%d스트라이크";

    public static final String NOTHING = "낫싱";

    public static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String RESTART_OR_END = "게임을 새로 시작하려면 " + RESTART +
            ", 종료하려면 " + END + "를 입력하세요.";

}
