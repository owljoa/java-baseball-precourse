package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    private static final String COMMA = ",";

    @Test
    @DisplayName("\"1,2\"를 콤마(,)로 split 하면 1과 2로 분리된다")
    void splitByComma_twoCharactersWithComma_separatedTwoCharacters() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(COMMA);

        // then
        Assertions.assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 콤마(,)로 split 하면 1만을 포함하는 배열이 반환된다")
    void split_oneCharacterWithComma_onlyOneCharacter() {
        // given
        String input = "1";

        // when
        String[] result = input.split(COMMA);

        // then
        Assertions.assertThat(result).containsExactly(input);
    }

    @Test
    @DisplayName("\"(1,2)\"가 주어지면 1과 (문자열 길이 - 1)을 입력받아 substring 하면 양 끝에 있는 소괄호를 제외한 문자열을 반환한다")
    void substring_stringWithParenthesesOnBothEnds_stringWithoutParenthesesOnBothEnds() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("입력된 위치가 대상 문자열의 범위를 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다")
    void charAt_inputIndexIsOutOfBound_StringIndexOutOfBoundsException() {
        // given
        String input = "abc";

        // when, then
        Assertions.assertThatThrownBy(() -> {
            char result = input.charAt(input.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + input.length());
    }
}
