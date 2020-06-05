package ru.geekbrains.lesson01;

public class Main {
    public static void main(String[] args) {

        // 3 задача
        float a = 2, b = 3, c = 5.5f, d = 7;
        System.out.println(someFunction(a, b, c, d)); // 2 * (3 + (5.5 / 7)) = 7.5714283

        // 4 задача
        int valueFirst = 15;
        int valueSecond = 5;
        System.out.println(withinTheBounds(valueFirst, valueSecond)); // 15 + 5 = 20,  20 >= 10 и 20 <= 20 = true

        // 5 задача
        int value = -5;
        printPositiveOrNegative(value); // -5 < 0 = "Value: -5, is negative"

        // 6 задача
        int value2 = 5;
        System.out.println(isNegative(value2)); // 5 > 0 = false

        // 7 задача
        String name = "Dima";
        printHello(name); // "Привет, Dima!"

        // 8 задача
        printLeapYear(2020); // "This year is leap year"
    }

    // Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float someFunction(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    // Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean withinTheBounds(int firstValue, int secondValue) {
        int summValue = firstValue + secondValue;

        if (summValue >= 10 && summValue <= 20)
            return true;

        return false;
    }

    // Написать метод, которому в качестве параметра передается целое число, метод должен
    // напечатать в консоль, положительное ли число передали или отрицательное.
    // Замечание: ноль считаем положительным числом.
    public static void printPositiveOrNegative(int value) {
        String result = "positive";
        if (value < 0)
            result = "negative";

        System.out.println("Value: " + value + ", is " + result);
    }

    // Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное.
    public static boolean isNegative(int value) {
        if (value < 0)
            return true;

        return false;
    }

    // Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void printLeapYear(int year) {
        if ((year % 4 != 0)
            || (year % 100 == 0 && year % 400 != 0))
            System.out.println("This year is not leap year");
        else
            System.out.println("This year is leap year");
    }

}
