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

    // 재시작시 컴퓨터의 게임넘버를 갱신 해주기 위한 setter
//    public void setComputerGameNumber(String computerGameNumber) {
//        this.computerGameNumber = computerGameNumber;
//    }

    public void refreshGameNumber() {
        this.computerGameNumber = new ComputerRandomNumber().getComputerNumber();
    }
}
