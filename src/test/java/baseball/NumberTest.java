package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
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
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void constructor_betweenOneAndNine_returnNumber(int number) {
        // when
        Number numberObj = new Number(number);

        // then
        Assertions.assertEquals(number, numberObj.getNumber());
    }

}