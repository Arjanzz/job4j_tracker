package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        map.put("parsentev@mail.ru", "Dmitry Sergeevich");
        map.put("parsentev@rumbler.ru", "Sergey Sergeevich");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
