package baseball.service;

import java.util.List;

public class CountResult {

    private static final int FULL_STRIKE_COUNT = 3;

    public int countStrikes(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikes = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (isStrike(i, playerNumbers, computerNumbers)) {
                strikes++;
            }
        }
        return strikes;
    }

    public int countBalls(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int balls = 0;
        for (Integer number : playerNumbers) {
            if (isBall(number, playerNumbers, computerNumbers)) {
                balls++;
            }
        }
        return balls;
    }

    private boolean isStrike(int i, List<Integer> playerNumbers, List<Integer> computerNumbers) {
        return playerNumbers.get(i).equals(computerNumbers.get(i));
    }

    private boolean isBall(Integer number, List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int playerNumberIndex = playerNumbers.get(playerNumbers.indexOf(number));
        int computerNumberIndex = computerNumbers.get(playerNumbers.indexOf(number));
        return computerNumbers.contains(number) && !(playerNumberIndex == computerNumberIndex);
    }

    public boolean judgementEndGame(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        return countStrikes(playerNumbers, computerNumbers) == FULL_STRIKE_COUNT;
    }

}
