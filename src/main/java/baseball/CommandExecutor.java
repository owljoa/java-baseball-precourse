package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    private static final String NEW_GAME_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    private final Game game;

    public CommandExecutor(Game game) {
        this.game = game;
    }

    public void startReadInput() {
        game.start();
        while (!game.isExit()) {
            printRequestCommandMessage();
            handleInput(Console.readLine());
        }
    }

    private void printRequestCommandMessage() {
        if (game.isSuspended()) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return;
        }
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void handleInput(String inputString) {
        validateInputNumber(inputString);

        if (game.isSuspended()) {
            handleCommand(inputString);
            return;
        }

        handleNumbers(inputString);
    }

    private void validateInputNumber(String inputNumberString) {
        try {
            Integer.parseInt(inputNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 처리할 수 있습니다.");
        }
    }

    private void handleCommand(String command) {
        if (command.equals(NEW_GAME_COMMAND)) {
            game.start();
            return;
        }

        if (command.equals(EXIT_COMMAND)) {
            game.exit();
            System.out.println("게임 완전 종료");
        }
    }

    private void handleNumbers(String inputNumberString) {
        List<Integer> integers = makeIntegerListFromString(inputNumberString);
        game.enterChallengerNumber(integers);

        System.out.println(game.judgeAndGetJudgementResultMessage());
    }

    private List<Integer> makeIntegerListFromString(String inputNumberString) {
        List<Integer> integers = new ArrayList<>();

        for (int index = 0; index < inputNumberString.length(); index++) {
            String singleNumberString = inputNumberString.substring(index, index + 1);
            int integer = Integer.parseInt(singleNumberString);
            integers.add(integer);
        }

        return integers;
    }
}
