package baseball;

import org.junit.jupiter.api.Test;
import baseball.controller.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    void 자릿수_예외_테스트() {
        final String input = "";

        assertThatThrownBy(() -> {
            Validator.validateLength(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_예외_테스트_숫자() {
        final String input = "0";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRangeNumber(input);
        });
    }

    @Test
    void 범위_예외_테스트_문자() {
        final String input = "a!1";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRangeString(input);
        });
    }

    @Test
    void 중복_예외_테스트() {
        final String input = "112";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateDuplicate(input);
        });
    }
}