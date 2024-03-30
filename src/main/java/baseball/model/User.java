package baseball.model;

import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public List<Integer> getNumbers() {
        return userNumbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.userNumbers = numbers;
    }
}
