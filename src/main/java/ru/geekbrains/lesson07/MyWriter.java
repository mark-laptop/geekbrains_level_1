package ru.geekbrains.lesson07;

import java.io.*;

public class MyWriter {

    // склеиваем данные файлов в новый файл по очереди
    public static void mergeTextFilesToTextFile(String[] fileNamesFrom, String fileNameTo) throws IOException {
        CharArrayWriter[] charArrayWriters = new CharArrayWriter[fileNamesFrom.length];

        for (int i = 0; i < fileNamesFrom.length; ++i) {
            charArrayWriters[i] = readFromFileToCharArray(fileNamesFrom[i]);
        }

        for (int i = 0; i < charArrayWriters.length; ++i) {
            writeCharArrayToFile(charArrayWriters[i], fileNameTo, true, true);
        }
    }

    // записываем данные файла в массив символов
    public static CharArrayWriter readFromFileToCharArray(String fileName) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            char[] tempCharArray = new char[1024];
            while (br.ready()) {
                int tempCountByte = br.read(tempCharArray);
                charArrayWriter.write(tempCharArray, 0, tempCountByte);
            }
            return charArrayWriter;
        } catch (IOException e) {
            String message = String.format("Ошибка при чтении файла %s", fileName);
            throw new IOException(message, e);
        }
    }

    // записываем из массива символов данные  в файл
    public static void writeCharArrayToFile(CharArrayWriter charArrayWriter, String fileName, boolean append, boolean addLineBreak) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            charArrayWriter.writeTo(bw);
            if (addLineBreak) {
                bw.write('\n');
            }
            bw.flush();
        } catch (IOException e) {
            String message = String.format("Ошибка при записи в файл %s", fileName);
            throw new IOException(message, e);
        }
    }

    // проверка на содержание переданной строки в файле
    public static boolean containsStringToFile(String fileName, String word) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while (bufferedReader.ready()) {
                String words = bufferedReader.readLine();
                if (words.contains(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            String message = String.format("Ошибка при чтении файла %s", fileName);
            throw new IOException(message, e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    String message = String.format("Ошибка при закрытии файла %s", fileName);
                    throw new IOException(message, e);
                }
            }
        }
        return false;
    }

    // проверка на содержание переданной строки в файлах
    public static boolean containsStringToFiles(String[] fileNames, String word) throws IOException {
        for (int i = 0; i < fileNames.length; ++i) {
            if (!containsStringToFile(fileNames[i], word)) {
                return false;
            }
        }
        return true;
    }

    // проверка на содержание переданной строки в файлах указанной директории
    public static boolean containsStringToFilesInDirectory(String directory, String word) throws IOException {
        File fileDirectory = new File(directory);
        File[] filesArray = fileDirectory.listFiles();
        for (File file : filesArray) {
//            System.out.println(file.getAbsolutePath());
            if (file.isFile() && containsStringToFile(file.getAbsolutePath(), word))
                return true;
        }
        return false;
    }

    // добавление переданной строки в каждый файл в указанной директории
    public static void addStrtingInFilesToDirectory(String directory, String word, boolean deepPass) throws IOException {
        File fileDirectory = new File(directory);
        File[] filesArray = fileDirectory.listFiles();
        for (File file : filesArray) {
//            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                if (deepPass)
                    addStrtingInFilesToDirectory(file.getAbsolutePath(), word, deepPass);
                continue;
            }
            // используем метод реализованный выше writeCharArrayToFile
            CharArrayWriter charArrayWriter = new CharArrayWriter(word.length());
            charArrayWriter.write(word);
            writeCharArrayToFile(charArrayWriter, file.getAbsolutePath(), true, false);
        }
    }
}
