package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

class NumberGeneratorTest {

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void generateNumbers_success() {
        // when
        Numbers numbers = NumberGenerator.generateNumbers();

        Set<Integer> integerSet = new HashSet<>();
        for (Number number : numbers.getNumbers()) {
            integerSet.add(number.getNumber());
        }

        // then
        Assertions.assertEquals(Numbers.NUMBER_SIZE_CONDITION, integerSet.size());
    }
}