package baseball.service;

import baseball.dto.GameResultDto;

public class GameNumberValidateService {

    private final int NUMBER_LENGTH = 3;

    private int ballCount;
    private int strikeCount;


    public GameResultDto calculateGameNumber(String computerNumber, String playerNumber) {
        resetCalculator();
        ballCount = calculateBallCount(computerNumber, playerNumber);
        strikeCount = calculateStrikeCount(computerNumber, playerNumber);

        return new GameResultDto(ballCount, strikeCount);
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

    private void resetCalculator() {
        ballCount = 0;
        strikeCount = 0;
    }
}