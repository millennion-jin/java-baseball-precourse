package baseball.dto;

public class GameResultDto {
    private int numStrike;
    private int numBall;
    private boolean isFinished;

    public GameResultDto() {
        numStrike = 0;
        numBall = 0;
        isFinished = false;
    }

    public int getNumStrike() {
        return numStrike;
    }

    public void setNumStrike(int numStrike) {
        this.numStrike = numStrike;
    }

    public int getNumBall() {
        return numBall;
    }

    public void setNumBall(int numBall) {
        this.numBall = numBall;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
