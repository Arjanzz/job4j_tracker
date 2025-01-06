package ru.job4j.queue;

import java.util.Deque;
import java.util.LinkedList;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder resut = new StringBuilder();
        int size = evenElements.size();

        for (int i = 0; i < size; i++) {
            Character element = evenElements.poll();
            if (i % 2 == 0) {
                resut.append(element);
            }
        }
        return resut.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        Deque<Character> deque = new LinkedList<>(descendingElements);
        while (!deque.isEmpty()) {
            result.append(deque.pollLast());
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}