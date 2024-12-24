package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus1 = new Airbus("A320");
        System.out.println(airbus1);
        airbus1.printModel();
        airbus1.printCountEngine();
        System.out.println();

        Airbus airbus2 = new Airbus("A380");
        System.out.println(airbus2);
        airbus2.printModel();
        airbus2.printCountEngine();
    }
}