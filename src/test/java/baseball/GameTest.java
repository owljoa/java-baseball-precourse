package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("생성자는 종료된 상태의 게임을 생성")
    void constructor_returnGame() {
        // when
        Game game = new Game();

        // then
        Assertions.assertNotNull(game);
        Assertions.assertTrue(game.isExit());
        Assertions.assertFalse(game.isSuspended());
    }

    @Test
    @DisplayName("게임시작 시 게임은 종료나 일시중지된 상태가 아니게 됨")
    void start_success() {
        // given
        Game game = new Game();

        // when
        game.start();

        // then
        Assertions.assertFalse(game.isExit());
        Assertions.assertFalse(game.isSuspended());
    }


    @Test
    @DisplayName("게임종료 시 게임은 종료된 상태가 됨")
    void exit_success() {
        // given
        Game game = new Game();
        game.start();

        // when
        game.exit();

        // then
        Assertions.assertTrue(game.isExit());
        Assertions.assertFalse(game.isSuspended());
    }
}