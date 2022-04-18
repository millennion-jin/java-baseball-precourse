package baseball.util;

import baseball.constants.GameOptionConstants;
import java.util.HashSet;
import java.util.Set;

public class GameValidationUtil {

    public static void validateGameInput(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException("inputValue is null.");
        }

        validateLength(inputValue);
        validateDuplication(inputValue);
        validateInRange(inputValue);
    }

    private static void validateLength(String inputValue) {
        if (inputValue.length() != GameOptionConstants.OPTION_NUMBER_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("length of inputValue is not %d.", GameOptionConstants.OPTION_NUMBER_LENGTH));
        }
    }

    private static void validateDuplication(String inputValue) {
        char[] inputChars = inputValue.toCharArray();

        Set<Character> charSet = new HashSet<>();
        for(char curChar : inputChars) {
            charSet.add(curChar);
        }

        if(charSet.size() < GameOptionConstants.OPTION_NUMBER_LENGTH) {
            throw new IllegalArgumentException("inputValue has duplicated num.");
        }
    }

    private static void validateInRange(String inputValue) {
        char[] inputChars = inputValue.toCharArray();
        for (char targetChar : inputChars) {
            validateInRangeNum(targetChar);
        }
    }

    private static void validateInRangeNum(char targetChar) {
        if (targetChar < '0' + GameOptionConstants.OPTION_NUMBER_RANGE_START
                || targetChar > '0' + GameOptionConstants.OPTION_NUMBER_RANGE_END) {
            throw new IllegalArgumentException("inputValue has not allowed text.");
        }
    }
}
