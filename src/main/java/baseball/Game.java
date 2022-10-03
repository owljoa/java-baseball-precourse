package baseball;

import java.util.List;

public class Game {

    private static final int WINNING_STRIKE_COUNT = 3;
    private static final String WHITE_SPACE = " ";
    private static final String NOTHING = "낫싱";

    private boolean isExit;
    private boolean isSuspended;
    private final Player defender;
    private final Player challenger;

    public Game() {
        this.isExit = true;
        this.isSuspended = false;
        this.defender = new Player();
        this.challenger = new Player();
    }

    public boolean isExit() {
        return isExit;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void start() {
        this.isExit = false;
        this.isSuspended = false;
        defender.generateNumbers();
    }

    public void exit() {
        this.isSuspended = false;
        this.isExit = true;
    }

    public void enterChallengerNumber(List<Integer> integers) {
        challenger.enterNumbers(integers);
    }

    public String judgeAndGetJudgementResultMessage() {
        Judgement judgement = judge();
        return getJudgementResultMessage(judgement);
    }

    private Judgement judge() {
        Judgement judgement = defender.getNumbers().judgeNumbers(challenger.getNumbers());

        if (judgement.getStrikeCount() == WINNING_STRIKE_COUNT) {
            suspend();
        }

        return judgement;
    }

    private void suspend() {
        this.isSuspended = true;
    }

    private String getJudgementResultMessage(Judgement judgement) {
        if (judgement.getStrikeAndBallCount() == 0) {
            return NOTHING;
        }

        return makeBallAndStrikeJudgementString(judgement);
    }

    private String makeBallAndStrikeJudgementString(Judgement judgement) {
        if (judgement.getStrikeCount() == WINNING_STRIKE_COUNT) {
            String winningMessage = String.format("%n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return makeStrikeJudgementString(judgement) + winningMessage;
        }
        return makeBallJudgementString(judgement) + makeStrikeJudgementString(judgement);
    }

    private String makeBallJudgementString(Judgement judgement) {
        if (judgement.getBallCount() == 0) {
            return "";
        }

        return String.format("%d볼", judgement.getBallCount());
    }

    private String makeStrikeJudgementString(Judgement judgement) {
        if (judgement.getStrikeCount() == 0) {
            return "";
        }

        if (judgement.getStrikeCount() > 0 && judgement.getBallCount() == 0) {
            return String.format("%d스트라이크", judgement.getStrikeCount());
        }

        return String.format("%s%d스트라이크", WHITE_SPACE, judgement.getStrikeCount());
    }
}
