package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calc(-1));
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void whenNotException() {
        assertThat(Factorial.calc(0)).isEqualTo(1);
        assertThat(Factorial.calc(1)).isEqualTo(1);
        assertThat(Factorial.calc(2)).isEqualTo(2);
        assertThat(Factorial.calc(3)).isEqualTo(6);
        assertThat(Factorial.calc(4)).isEqualTo(24);
        assertThat(Factorial.calc(5)).isEqualTo(120);
    }
}