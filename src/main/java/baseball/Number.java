package baseball;

import java.util.Objects;

public class Number {

    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
