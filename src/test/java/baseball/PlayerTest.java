package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlayerTest {

    @Test
    void enterNumbers_success() {
        // given
        Player player = new Player();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        // when
        player.enterNumbers(integers);

        // then
        List<Number> numbers = player.getNumbers().getNumbers();
        for (int index = 0; index < numbers.size(); index++) {
            Assertions.assertEquals(integers.get(index), numbers.get(index).getNumber());
        }
    }

    @Test
    void generateNumbers_success() {
        // given
        Player player = new Player();

        // when
        player.generateNumbers();

        // then
        Assertions.assertNotNull(player.getNumbers());
    }
}