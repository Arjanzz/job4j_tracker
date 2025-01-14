package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByIncPriority() {
        Comparator<Job> cmpPriority = new JobIncByPriority();
        int rsl = cmpPriority.compare(
                new Job("A Task", 0),
                new Job("B Task", 1)
        );
        assertThat(rsl).isLessThan(1);
    }

    @Test
    public void whenComparatorByIncNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobIncByPriority().thenComparing(new JobIncByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Some task", 0),
                new Job("Another task", 1)
        );
        assertThat(rsl).isLessThan(1);
    }

    @Test
    public void whenComparatorByIncName() {
        Comparator<Job> cmpName = new JobIncByName();
        int rsl = cmpName.compare(
                new Job("A task", 1),
                new Job("B Task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }
}