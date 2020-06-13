package ru.geekbrains.lesson07;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] fileNames = Arrays.copyOf(args, args.length - 1);

        try {
            MyWriter.mergeTextFilesToTextFile(fileNames, args[args.length - 1]);
            boolean result = MyWriter.containsStringToFile(args[args.length - 1], "привет");
            System.out.println(result);
            result = MyWriter.containsStringToFiles(args, "файл");
            System.out.println(result);
            result = MyWriter.containsStringToFilesInDirectory("C:\\Users\\Pro\\Desktop\\test", "fdasdfasfdasdfasfdasfasf");
            System.out.println(result);
            MyWriter.addStrtingInFilesToDirectory("C:\\Users\\Pro\\Desktop\\test", "Привет", true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
