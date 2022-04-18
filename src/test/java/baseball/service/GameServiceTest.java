package baseball.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.dto.GameResultDto;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    private GameService gameService = new GameService();

    @Test
    void 잘못된_입력값_입력시() {
        gameService.initGameService();

        assertThatThrownBy(() -> gameService.processGamePlay("113"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameService.processGamePlay("2345"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameService.processGamePlay("95E"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전부_틀렸을_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                gameService.initGameService();

                GameResultDto result = gameService.processGamePlay("162");
                assertThat(result.getNumBall()).isEqualTo(0);
                assertThat(result.getNumStrike()).isEqualTo(0);
                assertThat(result.isFinished()).isFalse();
            },
            3, 5, 7
        );
    }

    @Test
    void 하나_맞췄을_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                gameService.initGameService();

                GameResultDto result = gameService.processGamePlay("312");
                assertThat(result.getNumBall()).isEqualTo(0);
                assertThat(result.getNumStrike()).isEqualTo(1);
                assertThat(result.isFinished()).isFalse();
            },
            3, 6, 9
        );
    }

    @Test
    void 하나_맞추고_2볼인_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                gameService.initGameService();

                GameResultDto result = gameService.processGamePlay("132");
                assertThat(result.getNumBall()).isEqualTo(2);
                assertThat(result.getNumStrike()).isEqualTo(1);
                assertThat(result.isFinished()).isFalse();
            },
            1, 2, 3
        );
    }

    @Test
    void 볼이_3개인_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                gameService.initGameService();

                GameResultDto result = gameService.processGamePlay("562");
                assertThat(result.getNumBall()).isEqualTo(3);
                assertThat(result.getNumStrike()).isEqualTo(0);
                assertThat(result.isFinished()).isFalse();
            },
            6, 2, 5
        );
    }

    @Test
    void 스트라이크가_3개인_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                gameService.initGameService();

                GameResultDto result = gameService.processGamePlay("478");
                assertThat(result.getNumBall()).isEqualTo(0);
                assertThat(result.getNumStrike()).isEqualTo(3);
                assertThat(result.isFinished()).isTrue();
            },
            4, 7, 8
        );
    }

    @Test
    void 종료여부_확인시_정상_값_입력() {
        GameService gameService = new GameService();

        assertThat(gameService.checkContinueGame("1")).isTrue();
        assertThat(gameService.checkContinueGame("2")).isFalse();
    }

    @Test
    void 종료여부_확인시_비정상_값_입력() {
        GameService gameService = new GameService();

        assertThatThrownBy(() -> gameService.checkContinueGame("3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameService.checkContinueGame("c"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> gameService.checkContinueGame(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}