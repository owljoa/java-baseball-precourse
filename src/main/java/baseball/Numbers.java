package baseball;

import java.util.List;

public class Numbers {

    private static final int NUMBER_SIZE_CONDITION = 3;

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateNumberSizeCondition(numbers);
        validateDifferentEachOther(numbers);

        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private void validateNumberSizeCondition(List<Number> numbers) {
        if (numbers.size() != NUMBER_SIZE_CONDITION) {
            throw new IllegalArgumentException("세자릿수는 숫자 3개만으로 구성되어야 합니다.");
        }
    }

    private void validateDifferentEachOther(List<Number> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            int otherNumberStartIndex = index + 1;
            validateOneNumberDifferentFromOtherNumbers(index, otherNumberStartIndex, numbers);
        }
    }

    private void validateOneNumberDifferentFromOtherNumbers(int numberIndex, int otherNumberStartIndex, List<Number> numbers) {
        Number number = numbers.get(numberIndex);

        for (int index = otherNumberStartIndex + 1; index < numbers.size(); index++) {
            Number otherNumber = numbers.get(index);
            validateOneNumberNotEqualsToOther(number, otherNumber);
        }
    }

    private void validateOneNumberNotEqualsToOther(Number number, Number otherNumber) {
        if (number.equals(otherNumber)) {
            throw new IllegalArgumentException("세자릿수는 서로 다른 숫자로 구성되어야 합니다.");
        }
    }
}
