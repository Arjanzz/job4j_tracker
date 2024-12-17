package ru.job4j.tracker.output;

import ru.job4j.tracker.output.Output;

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object object) {
        buffer.append(object).append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}