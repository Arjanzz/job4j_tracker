package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);

    }

    public static void main(String[] args) {
        int resultSum = sum(5);
        System.out.println(resultSum);

        int resultMinus = minus(5);
        System.out.println(resultMinus);

        Calculator calculatorDivide = new Calculator();
        System.out.println(calculatorDivide.divide(5));

        Calculator calculatorMultiply = new Calculator();
        int multResult = calculatorMultiply.multiply(5);
        System.out.println(multResult);

        Calculator calculatorAllSum = new Calculator();
        System.out.println(calculatorAllSum.sumAllOperation(5));
    }
}