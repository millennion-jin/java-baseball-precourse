package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameValidationUtilTest {

    @Test
    void 서로다른_세_숫자() {
        GameValidationUtil.validateGameInput("471");
    }

    @Test
    void 중복_수_존재() {
        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("113"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 네_자리_이상() {
        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("2345"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("376257"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세_자리_미만() {
        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("34"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자에_0포함() {
        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("501"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("120"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_이외_문자열() {
        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("95E"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> GameValidationUtil.validateGameInput("9 1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}