package baseball.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void 잘못된_입력값_입력시() {
        GameService gameService = new GameService();
        gameService.initGameService();

        assertThatThrownBy(() -> gameService.processGamePlay("113"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameService.processGamePlay("2345"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameService.processGamePlay("95E"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}