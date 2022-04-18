package baseball.util;

import baseball.constants.GameOptionConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumberGenerateUtil {

    public static List<Integer> genRandomNumList() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < GameOptionConstants.OPTION_NUMBER_LENGTH) {
            addRandomNumToList(list);
        }

        return list;
    }

    private static void addRandomNumToList(List<Integer> list) {
        int num = Randoms.pickNumberInRange(GameOptionConstants.OPTION_NUMBER_RANGE_START,
                GameOptionConstants.OPTION_NUMBER_RANGE_END);

        if(!list.contains(num)) {
            list.add(num);
        }
    }
}
