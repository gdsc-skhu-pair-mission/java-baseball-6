package baseball.util;

public enum ErrorMessage {
    INPUT_NUMBER_NOT_NULL("입력 값이 null이 될 수 없습니다."),
    INPUT_NUMBER_DUPLICATE("입력 값이 중복되었습니다."),
    INPUT_NUMBER_NOT_3_DIGIT("입력 값이 3자리가 아닙니다."),
    INPUT_NUMBER_NOT_RANGE("입력 값이 범위에 맞지 않습니다."),
    RESTART_INPUT_WRONG_NUMBER("입력값이 올바르지 않습니다.");
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}
