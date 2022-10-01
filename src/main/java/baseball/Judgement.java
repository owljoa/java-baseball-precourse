package baseball;

public class Judgement {

    private int strikeCount = 0;
    private int ballCount = 0;


    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public int getStrikeAndBallCount() {
        return getStrikeCount() + getBallCount();
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
