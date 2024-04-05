package baseball.model;

import java.util.List;

public class User {
    private List<Integer> userNumbers;

    public List<Integer> getNumbers() {
        return userNumbers;
    }


    private User(Builder builder){
        this.userNumbers=builder.userNumbers;
    }

    public static class Builder{
        private List<Integer> userNumbers;
        public Builder(){}
        public Builder userNumbers(List<Integer> userNumbers){
            this.userNumbers=userNumbers;
            return this;

        }
        public User build(){
            return new User(this);
        }

    }
}
