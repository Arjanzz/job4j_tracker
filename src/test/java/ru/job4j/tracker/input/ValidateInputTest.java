package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputs() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "3", "4", "5"}
        );
        ValidateInput input = new ValidateInput(output, in);

        int[] expectedValues = {1, 2, 3, 4, 5};
        for (int expected : expectedValues) {
            int selected = input.askInt("Enter menu");
            assertThat(selected).isEqualTo(expected);
        }
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected).isEqualTo(-1);
    }
}