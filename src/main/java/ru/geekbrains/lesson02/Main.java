package ru.geekbrains.lesson02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        separator(1);
        int[] arrayInt1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrayInt1.length; i++) {
            if (arrayInt1[i] == 1)
                arrayInt1[i] = 0;
            else if (arrayInt1[i] == 0)
                arrayInt1[i] = 1;
        }
        System.out.println(Arrays.toString(arrayInt1));


        // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        separator(2);
        int[] arrayInt2 = new int[8];
        for (int i = 0; i < arrayInt2.length; i++) {
            arrayInt2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrayInt2));


        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        separator(3);
        int[] arrayInt3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayInt3.length; i++) {
            if (arrayInt3[i] < 6)
                arrayInt3[i] *= 2;
        }
        System.out.println(Arrays.toString(arrayInt3));


        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        separator(4);
        int[][] arrayInt4 = new int[7][7];
        for (int i = 0, j = i, y = arrayInt4.length - 1; i < arrayInt4.length; i++, j++, y--) {
            arrayInt4[i][j] = 1;
            arrayInt4[i][y] = 1;
        }
        for (int i = 0; i < arrayInt4.length; i++) {
            for (int j = 0; j < arrayInt4[i].length; j++) {
                System.out.printf("[%d] ", arrayInt4[i][j]);
            }
            System.out.println();
        }


        // ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        separator(5);
        int[] arrayInt5 = new int[]{2, 4, 5, 96_767_654, 1, 234, 56_554, 3, 100_000};
        int min = min(arrayInt5);
        int max = max(arrayInt5);
        System.out.println(Arrays.toString(arrayInt5));
        System.out.printf("Минимальный элемент: %d, максимальный элемент: %d\n", min, max);


        // ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        separator(6);
        int[] arrayInt6 = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(ischeckBalance(arrayInt6));


        // **** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        separator(7);
        int[] arrayInt7 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int shiftCount = -2;
        shift(arrayInt7, shiftCount);
        System.out.println(Arrays.toString(arrayInt7));
    }

    public static int min(int[] array) {
        if (array.length == 1)
            return array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }

    public static int max(int[] array) {
        if (array.length == 1)
            return array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result < array[i])
                result = array[i];
        }
        return result;
    }

    public static boolean ischeckBalance(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int tempSum = 0;
        for (int i = 0; i < array.length; i++) {
            tempSum += array[i];
            sum -= array[i];
            if (tempSum == sum) {
                //System.out.println(tempSum + " " + sum);
                return true;
            }
        }
        return false;
    }

    public static void shift(int[] array, int shiftCount) {
        shiftCount = shiftCount < 0 ? -shiftCount : shiftCount;
        for (int i = 0; i < shiftCount; i++) {
            for (int index = array.length - 1; index > 0; index--) {
                swap(array, index);
            }
        }
    }

    public static void swap(int[] array, int index) {
        int temp = array[index - 1];
        array[index - 1] = array[index];
        array[index] = temp;
    }

    public static void separator(int numberTask) {
        System.out.printf("Задание № %s: =======================================================\n", numberTask);
    }
}
