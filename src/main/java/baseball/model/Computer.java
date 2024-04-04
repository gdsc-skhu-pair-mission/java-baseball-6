package baseball.model;

import java.util.List;

public class Computer {

    private List<Integer> computerNumbers;

    private Computer(Builder builder) {
        this.computerNumbers = builder.computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
    public static class Builder {
        private List<Integer> computerNumbers;

        public Builder() {}

        public Builder computerNumbers(List<Integer> computerNumbers) {
            this.computerNumbers = computerNumbers;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}