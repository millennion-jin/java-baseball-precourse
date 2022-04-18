package baseball.service;

import baseball.constants.GameOptionConstants;
import baseball.dto.GameResultDto;
import baseball.model.GameModel;
import baseball.util.GameNumberGenerateUtil;
import baseball.util.GameValidationUtil;
import java.util.List;

public class GameService {

    private GameModel gameModel;

    public void initGameService() {
        List<Integer> targetNumList = GameNumberGenerateUtil.genRandomNumList();
        gameModel = new GameModel(targetNumList);
    }

    public GameResultDto processGamePlay(String inputValue) {
        GameValidationUtil.validateGameInput(inputValue);

        return getCompareResult(inputValue);
    }

    private GameResultDto getCompareResult(String inputValue) {
        GameResultDto dto = new GameResultDto();
        char[] inputChars = inputValue.toCharArray();

        for (int i = 0; i < inputChars.length; i++) {
            compareWithGameModel(dto, i, inputChars[i] - '0');
        }
        checkFinished(dto);

        return dto;
    }

    private void compareWithGameModel(GameResultDto dto, int curPos, int curNum) {
        List<Integer> targetNumList = gameModel.getTargetNumList();

        if (targetNumList.get(curPos) == curNum) {
            dto.setNumStrike(dto.getNumStrike() + 1);
            return;
        }

        if (targetNumList.contains(curNum)) {
            dto.setNumBall(dto.getNumBall() + 1);
        }
    }

    private void checkFinished(GameResultDto dto) {
        if (dto.getNumStrike() == GameOptionConstants.OPTION_NUMBER_LENGTH) {
            dto.setFinished(true);
        }
    }

}
