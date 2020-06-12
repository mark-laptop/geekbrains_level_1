package ru.geekbrains.lesson07;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Передайте в качестве параметров абсолютные пути к файлам, (последний параметр будет использоваться для записи)");
            return;
        }
        String[] fileNames = Arrays.copyOf(args, args.length - 1);
        try {
            MyWriter.mergeTextFilesToTextFile(fileNames, args[args.length - 1]);
            boolean result = MyWriter.containsWordToFile(args[args.length - 1], "третьего");
            System.out.println(result);
            result = MyWriter.containsWordToFiles(args, "файл");
            System.out.println(result);
            result = MyWriter.containsWordToFilesInDirectory("C:\\Users\\Pro\\Desktop", "BEGIN");
            System.out.println(result);
            MyWriter.addWordInFilesToDirectory("C:\\Users\\Pro\\Desktop\\test", "Привет");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
