package baseball.domain;

public final class Massage {

    public final static Integer RESTART = 1;

    public final static Integer END = 2;

    public final static Integer INPUT_LENGTH = 3;

    public final static Integer MIN = 1;

    public final static Integer MAX = 9;

    public final static String START = "숫자 야구 게임을 시작합니다.";

    public final static String INPUT = "숫자를 입력해주세요 : ";

    public final static String BALL = "%d볼";

    public final static String STRIKE = "%d스트라이크";

    public final static String NOTHING = "낫싱";

    public final static String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public final static String RESTART_OR_END = "게임을 새로 시작하려면 " + RESTART +
            ", 종료하려면 " + END + "를 입력하세요.";

    public final static String LENGTH_ERROR_MESSAGE = "3자리 수를 입력해야 합니다.";
    public final static String RANGE_ERROR_MESSAGE = "1과 9 사이의 숫자를 입력해야 합니다.";
    public final static String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 숫자를 입력해야 합니다.";

}
