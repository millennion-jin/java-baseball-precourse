package baseball.model;

import java.util.List;

public class GameModel {
    private final List<Integer> targetNumList;

    public GameModel(List<Integer> targetNumList) {
        this.targetNumList = targetNumList;
    }

    public List<Integer> getTargetNumList() {
        return targetNumList;
    }
}
