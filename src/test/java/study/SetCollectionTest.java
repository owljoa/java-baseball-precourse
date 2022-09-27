package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        // given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 구조에 1,1,2,3 을 삽입하면 중복된 1은 하나만 저장되어 Set의 크기가 3이 된다")
    void size_fourElementWithTwoDuplicatedValuesAdded_sizeIsThree() {
        // when
        int result = numbers.size();

        // then
        Assertions.assertEquals(3, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_containedValuesEntered_true(int input, boolean expected) {
        // when
        boolean result = numbers.contains(input);

        // then
        Assertions.assertEquals(expected, result);
    }
}
