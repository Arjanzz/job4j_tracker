package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
         return item;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            result[i] = items.get(i);
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getName().equals(key)) {
                result[index] = items.get(i);
                index++;
            }
        }
        return Arrays.copyOf(result, index);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        if (id < 0 || item == null) {
            throw new IllegalArgumentException("ID должен быть положительным числом, и объект item не должен быть null");
        }

        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            items.get(index).setId(id);
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index >= 0) {
            items.remove(index);
            items.add(size - 1, null);
            size--;
        }
    }
}