package ru.geekbrains.lesson07;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        WorkForFiles.appendStringToEndFile("C:\\Users\\Pro\\Desktop\\testResult.txt", "Привет", true);
    }
}
