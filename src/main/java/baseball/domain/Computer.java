package baseball.domain;

import baseball.util.ComputerRandomNumber;


public class Computer {

    private String computerGameNumber;

    public Computer() {
        refreshGameNumber();
    }

    public Computer(ComputerRandomNumber computerRandomNumber) {
        this.computerGameNumber = computerRandomNumber.getComputerNumber();
    }

    public String getComputerGameNumber() {
        return computerGameNumber;
    }

    public void refreshGameNumber() {
        this.computerGameNumber = new ComputerRandomNumber().getComputerNumber();
    }
}
