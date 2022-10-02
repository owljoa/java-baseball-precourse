package baseball;

import java.util.List;

public class Player {

    private Numbers numbers;

    public void enterNumbers(List<Integer> integers) {
        numbers = Numbers.create(integers);
    }

    public void generateNumbers() {
        numbers = NumberGenerator.generateNumbers();
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
