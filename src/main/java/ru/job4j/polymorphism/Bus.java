package ru.job4j.polymorphism;

import java.util.Scanner;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Move :");
        Scanner scanner = new Scanner(System.in);
        String side = scanner.nextLine();
        System.out.println("We're moving to " + side);
    }

    @Override
    public void passengers(int count) {
        System.out.println("Number of passengers: " + count);
    }

    @Override
    public int refuel(int fuel) {
       if (fuel > 0) {
           System.out.println("Liters: " + fuel);
       }
       return 0;
    }

    public static void main(String[] args) {
        new Bus().move();
        new Bus().passengers(123);
        new Bus().refuel(23);
    }
}
