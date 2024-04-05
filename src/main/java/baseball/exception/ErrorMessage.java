package baseball.exception;

public enum ErrorMessage {
    INVALID_LENGTH("입력은 3자리 숫자여야 합니다."),
    NOT_NUMERIC("입력은 숫자여야 합니다."),
    DUPLICATE_DIGITS("중복된 숫자는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}