package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberValidateService {

    private static final int NUMBER_LENGTH = 3;

    private int strikeCount;
    private int ballCount;
    private List<Integer> ballAndStrikeCountList = new ArrayList<>();


    public List<Integer> calculateGameNumber(String computerNumber, String playerNumber) {
        resetCalculator();
        ballCount = calculateBallCount(computerNumber, playerNumber);
        strikeCount = calculateStrikeCount(computerNumber, playerNumber);
        setBallAndStrikeCountList(ballCount, strikeCount);

        return ballAndStrikeCountList;
    }

    private int calculateBallCount(String computerNumber, String playerNumber) {
        for (int computerPlace = 0; computerPlace < NUMBER_LENGTH; computerPlace++) {
            ballCheck(computerNumber.charAt(computerPlace), playerNumber, computerPlace);
        }

        return ballCount;
    }

    private int calculateStrikeCount(String computerNumber, String playerNumber) {
        for (int place = 0; place < NUMBER_LENGTH; place++) {
            if (strikeCheck(computerNumber.charAt(place), playerNumber.charAt(place))){
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private void ballCheck(char computerNumber, String playerNumber, int computerPlaceLocation) {
        for (int playerPlace = 0; playerPlace < NUMBER_LENGTH; playerPlace++) {
            if (computerNumber == playerNumber.charAt(playerPlace) && computerPlaceLocation != playerPlace) {
                ballCount++;
            }
        }
    }

    private boolean strikeCheck(char computerNumber, char playerNumber) {
        return computerNumber == playerNumber;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setBallAndStrikeCountList(int ballCount, int strikeCount) {
        ballAndStrikeCountList.add(ballCount);
        ballAndStrikeCountList.add(strikeCount);
    }

    public void resetCalculator() {
        ballAndStrikeCountList.clear();
        ballCount = 0;
        strikeCount = 0;
    }
}