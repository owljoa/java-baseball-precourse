package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

    @ParameterizedTest(name = "도전자 플레이어가 숫자 {0}{1}{2}를 입력하면, 판정 메시지 [{3}]을 출력")
    @CsvSource(
            value = {
                    "1:2:3:'3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료'",
                    "1:4:3:2스트라이크",
                    "1:3:4:1볼 1스트라이크",
                    "2:3:5:2볼",
                    "5:6:7:낫싱",
            },
            delimiter = ':')
    void judgeAndGetJudgementResultMessage_returnJudgementResultMessage(int number1, int number2, int number3, String expected) {
        // given
        Game game = new Game();
        List<Integer> challengerNumber = generateIntegerList(number1, number2, number3);
        game.enterChallengerNumber(challengerNumber);

        // when
        String judgementResultMessage = doJudgeAndGetJudgementResultMessage(game);

        // then
        Assertions.assertEquals(expected, judgementResultMessage);
    }

    private List<Integer> generateIntegerList(int number1, int number2, int number3) {
        List<Integer> challengerNumber = new ArrayList<>();
        challengerNumber.add(number1);
        challengerNumber.add(number2);
        challengerNumber.add(number3);

        return challengerNumber;
    }

    private String doJudgeAndGetJudgementResultMessage(Game game) {
        MockedStatic.Verification verification = () -> Randoms.pickNumberInRange(
                ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()
        );

        try (final MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            mock.when(verification).thenReturn(1, 2, 3);
            game.start();

            return game.judgeAndGetJudgementResultMessage();
        }
    }
}