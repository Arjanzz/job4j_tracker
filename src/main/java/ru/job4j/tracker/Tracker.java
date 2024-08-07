package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
         return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[index] = items[i];
                index++;
            }
        }
        return Arrays.copyOf(result, index);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        if (id < 0 || item == null) {
            throw new IllegalArgumentException("ID должен быть положительным числом, и объект item не должен быть null");
        }

        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            items[index].setId(id);
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index >= 0) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
    }
}