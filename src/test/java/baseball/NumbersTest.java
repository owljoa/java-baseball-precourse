package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NumbersTest {

    @Test
    @DisplayName("숫자의 갯수가 3개가 아니면 세자릿수 생성 시 예외발생")
    void constructor_violatedNumberSizeCondition_illegalArgumentException() {
        // given
        List<Number> numberList = new ArrayList<>();
        numberList.add(new Number(1));
        numberList.add(new Number(2));

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Numbers(numberList);
        });
    }

    @Test
    @DisplayName("서로 다른 숫자가 아니면 세자릿수 생성 시 예외발생")
    void constructor_SameEachOther_illegalArgumentException() {
        // given
        List<Number> numberList = new ArrayList<>();
        numberList.add(new Number(1));
        numberList.add(new Number(2));
        numberList.add(new Number(1));

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Numbers(numberList);
        });
    }

    @Test
    @DisplayName("서로 다른 3개의 숫자로 세자릿수 생성 시 생성된 세자릿수 반환")
    void constructor_differentEachOtherAndFollowedNumberSizeCondition_returnNumbers() {
        // given
        List<Number> numberList = new ArrayList<>();
        numberList.add(new Number(1));
        numberList.add(new Number(2));
        numberList.add(new Number(3));

        // when
        Numbers numbers = new Numbers(numberList);

        // then
        for (int i = 0; i < numberList.size(); i++) {
            Assertions.assertEquals(numberList.get(i), numbers.getNumbers().get(i));
        }
    }

}