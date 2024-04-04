package baseball.util;

public class ExceptionHandler {

    public static void CustomException(ErrorMessage errorMessage) {
        System.out.println("[Error] " + errorMessage.message);
        throw new IllegalArgumentException(errorMessage.message);
    }
}