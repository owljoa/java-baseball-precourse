package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandExecutorTest extends ApplicationTest {

    @Test
    void startReadInput_inputIsNotNumber_illegalArgumentException() {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            run("1a2");
        });
    }
}