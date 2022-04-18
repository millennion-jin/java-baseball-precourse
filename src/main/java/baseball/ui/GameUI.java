package baseball.ui;

import baseball.constants.GameMessageConstants;
import baseball.dto.GameResultDto;

public class GameUI {

    private String convertResultToMessage(GameResultDto dto) {
        StringBuilder builder = new StringBuilder();

        addBallMessage(builder, dto);
        addStrikeMessage(builder, dto);
        addNothingMessage(builder, dto);

        return builder.toString();
    }

    private void addBallMessage(StringBuilder builder, GameResultDto dto) {
        if (dto.getNumBall() > 0) {
            builder.append(dto.getNumBall());
            builder.append(GameMessageConstants.MESSAGE_STATE_BALL);
        }
    }

    private void addStrikeMessage(StringBuilder builder, GameResultDto dto) {
        if (dto.getNumStrike() > 0) {
            addSpaceIfNotEmpty(builder);

            builder.append(dto.getNumStrike());
            builder.append(GameMessageConstants.MESSAGE_STATE_STRIKE);
        }
    }

    private void addNothingMessage(StringBuilder builder, GameResultDto dto) {
        if (dto.getNumStrike() == 0 && dto.getNumBall() == 0) {
            builder.append(GameMessageConstants.MESSAGE_STATE_NOTHING);
        }
    }

    private void addSpaceIfNotEmpty(StringBuilder builder) {
        if (builder.length() != 0) {
            builder.append(" ");
        }
    }

}
