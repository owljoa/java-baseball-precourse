package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest(name = "입력값이 {arguments}이면 1~9 사이의 숫자가 아니므로 예외 발생")
    @ValueSource(ints = {0, 10})
    void constructor_numberNotBetweenOneAndNine_illegalArgumentException(int number) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Number(number);
        });
    }

    @ParameterizedTest(name = "입력값이 {arguments}이면 1~9 사이의 숫자이므로 생성된 객체 반환")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void constructor_betweenOneAndNine_returnNumber(int number) {
        // when
        Number numberObj = new Number(number);

        // then
        Assertions.assertEquals(number, numberObj.getNumber());
    }

    @ParameterizedTest(name = "{0}과 {1}을 가진 Number 객체를 equals 메소드로 비교하면 {2} 반환")
    @CsvSource(value = {"1:1:true", "2:2:true", "1:2:false", "2:1:false"}, delimiter = ':')
    void equals_sameNumberValues_returnTrue(int number1, int number2, boolean expected) {
        // given
        Number numberA = new Number(number1);
        Number numberB = new Number(number2);

        // when
        boolean result = numberA.equals(numberB);

        // then
        Assertions.assertEquals(expected, result);
    }

}