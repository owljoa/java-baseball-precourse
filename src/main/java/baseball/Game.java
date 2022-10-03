package baseball;

import java.util.List;

public class Game {

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
}
