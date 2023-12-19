package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item someItem = new Item();
        someItem.setName("test1");
        tracker.add(someItem);
        Item result = tracker.findById(someItem.getId());
        assertThat(result.getName()).isEqualTo(someItem.getName());
    }
}