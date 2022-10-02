package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {

    public static Numbers generateNumbers() {
        List<Number> numberList = new ArrayList<>();
        Set<Integer> integerSet = new HashSet<>();

        while (numberList.size() < Numbers.NUMBER_SIZE_CONDITION) {
            Number number = generateNumber();
            addNumberIfNotDuplicated(integerSet, numberList, number);
        }

        return new Numbers(numberList);
    }

    private static void addNumberIfNotDuplicated(Set<Integer> integerSet, List<Number> numberList, Number number) {
        if (!integerSet.contains(number.getNumber())) {
            integerSet.add(number.getNumber());
            numberList.add(number);
        }
    }

    private static Number generateNumber() {
        return new Number(Randoms.pickNumberInRange(Number.MIN_NUMBER, Number.MAX_NUMBER));
    }
}
