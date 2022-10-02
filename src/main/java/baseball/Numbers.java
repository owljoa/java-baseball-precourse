package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public static final int NUMBER_SIZE_CONDITION = 3;

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateNumberSizeCondition(numbers);
        validateDifferentEachOther(numbers);

        this.numbers = numbers;
    }

    public static Numbers create(List<Integer> integers) {
        List<Number> numbers = new ArrayList<>();
        for (int integer : integers) {
            numbers.add(new Number(integer));
        }
        return new Numbers(numbers);
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

    public Judgement judgeNumbers(Numbers numbers) {
        Judgement judgement = new Judgement();

        int index = 0;
        while (index < getSize() && judgement.getStrikeAndBallCount() != getSize()) {
            Number challengerNumber = numbers.get(index);
            judgeSingleNumber(challengerNumber, index, judgement);

            index++;
        }

        return judgement;
    }

    private void judgeSingleNumber(Number challengerNumber, int targetNumberIndex, Judgement judgement) {
        if (judgeStrike(challengerNumber, targetNumberIndex, judgement)) {
            return;
        }
        judgeBall(challengerNumber, judgement);
    }


    private boolean judgeStrike(Number challengerNumber, int targetNumberIndex, Judgement judgement) {
        if (challengerNumber.equals(get(targetNumberIndex))) {
            judgement.increaseStrikeCount();
            return true;
        }
        return false;
    }

    private void judgeBall(Number challengerNumber, Judgement judgement) {
        int index = 0;

        while (index < getSize() && !challengerNumber.equals(get(index))) {
            index++;
        }

        if (index < getSize()) {
            judgement.increaseBallCount();
        }
    }

    private Number get(int index) {
        return numbers.get(index);
    }

    private int getSize() {
        return numbers.size();
    }
}
