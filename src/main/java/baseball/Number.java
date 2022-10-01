package baseball;

public class Number {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private final int number;

    public Number(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 1~9 사이의 값이어야 합니다.");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
