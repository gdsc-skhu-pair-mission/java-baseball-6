package baseball.service;

import java.util.List;

public class CountResult {

    private static final int FULL_STRIKE_COUNT = 3;

    public int countStrikes(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikes = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int balls = 0;

        for (Integer number : playerNumbers) {
            if (computerNumbers.contains(number) && !playerNumbers.get(playerNumbers.indexOf(number))
                    .equals(computerNumbers.get(playerNumbers.indexOf(number)))) {
                balls++;
            }
        }

        return balls;
    }

    public boolean judgementEndGame(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        return countStrikes(playerNumbers, computerNumbers) == FULL_STRIKE_COUNT;
    }

}
