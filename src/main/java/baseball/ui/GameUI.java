package baseball.ui;

import baseball.constants.GameMessageConstants;
import baseball.constants.GameOptionConstants;
import baseball.dto.GameResultDto;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameUI {
    private final GameService gameService;

    public GameUI() {
        gameService = new GameService();
    }

    public void play() {
        do {
            gameService.initGameService();
            processGamePlay();
        } while(checkContinue());


    }

    private void processGamePlay() {
        while(true) {
            printPleaseInputMsg();
            String inputValue = readInputValue();

            GameResultDto result = gameService.processGamePlay(inputValue);
            printResult(result);

            if(result.isFinished()) break;
        }
    }

    private void printPleaseInputMsg() {
        System.out.printf("%s : ", GameMessageConstants.MESSAGE_PLEASE_INPUT);
    }

    private String readInputValue() {
        return Console.readLine();
    }

    private void printResult(GameResultDto dto) {
        System.out.println(convertResultToMessage(dto));
        if (dto.isFinished()) {
            System.out.printf((GameMessageConstants.MESSAGE_FINISHED) + "%n", GameOptionConstants.OPTION_NUMBER_LENGTH);
        }
    }

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

    private boolean checkContinue() {
        System.out.printf((GameMessageConstants.MESSAGE_CONTINUE) + "%n", GameOptionConstants.OPTION_CONTINUE_TEXT,
                GameOptionConstants.OPTION_FINISH_TEXT);

        String inputValue = readInputValue();
        return gameService.checkContinueGame(inputValue);
    }

}
