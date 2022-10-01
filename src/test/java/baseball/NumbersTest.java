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

    @Test
    @DisplayName("두 세자릿수의 각 위치별 숫자가 모두 같으면 3스트라이크로 판정")
    void judgeNumbers_sameNumbersOnSamePositions_threeStrike() {
        // given
        Numbers defenderNumber = generateNumbers(1, 2, 3);
        Numbers challengerNumbers = generateNumbers(1, 2, 3);

        // when
        Judgement judgement = defenderNumber.judgeNumbers(challengerNumbers);

        // then
        Assertions.assertEquals(3, judgement.getStrikeCount());
        Assertions.assertEquals(0, judgement.getBallCount());
    }

    @Test
    @DisplayName("두 세자릿수의 숫자들 중 같은 위치이면서 같은 숫자가 1개, 숫자는 같지만 다른 위치인 숫자가 2개이면 1스트라이트 2볼로 판정")
    void judgeNumbers_oneIsSameAndSamePositionOthersAreSameButNotSamePosition_oneStrikeTwoBall() {
        // given
        Numbers defenderNumber = generateNumbers(1, 3, 2);
        Numbers challengerNumbers = generateNumbers(1, 2, 3);

        // when
        Judgement judgement = defenderNumber.judgeNumbers(challengerNumbers);

        // then
        Assertions.assertEquals(1, judgement.getStrikeCount());
        Assertions.assertEquals(2, judgement.getBallCount());
    }

    @Test
    @DisplayName("두 세자릿수의 숫자들 중 같은 위치가 아니면서 같은 숫자가 3개이면, 3볼로 판정")
    void judgeNumbers_sameNumbersOnDifferentPositions_threeBall() {
        // given
        Numbers defenderNumber = generateNumbers(1, 2, 3);
        Numbers challengerNumbers = generateNumbers(2, 3, 1);

        // when
        Judgement judgement = defenderNumber.judgeNumbers(challengerNumbers);

        // then
        Assertions.assertEquals(0, judgement.getStrikeCount());
        Assertions.assertEquals(3, judgement.getBallCount());
    }

    @Test
    @DisplayName("두 세자릿수의 숫자들 중 같은 숫자가 하나도 없다면, 0스트라이크 0볼로 판정")
    void judgeNumbers_noSameNumber_zeroStrikeZeroBall() {
        // given
        Numbers defenderNumber = generateNumbers(1, 2, 3);
        Numbers challengerNumbers = generateNumbers(4, 5, 6);

        // when
        Judgement judgement = defenderNumber.judgeNumbers(challengerNumbers);

        // then
        Assertions.assertEquals(0, judgement.getStrikeCount());
        Assertions.assertEquals(0, judgement.getBallCount());
    }

    private Numbers generateNumbers(int number1, int number2, int number3) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(new Number(number1));
        numberList.add(new Number(number2));
        numberList.add(new Number(number3));

        return new Numbers(numberList);
    }
}