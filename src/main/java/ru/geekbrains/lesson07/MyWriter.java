package ru.geekbrains.lesson07;

import java.io.*;

public class MyWriter {

    public static void mergeTextFilesToTextFile(String[] fileNamesFrom, String fileNameTo) throws IOException {

        CharArrayWriter[] charArrayWriters = new CharArrayWriter[fileNamesFrom.length];
        for (int i = 0; i < fileNamesFrom.length; i++) {
            charArrayWriters[i] = readFromFileToCharArray(fileNamesFrom[i]);
        }

        for (int i = 0; i < charArrayWriters.length; i++) {
            writeCharArrayToFile(charArrayWriters[i], fileNameTo, true, true);
        }
    }

    public static CharArrayWriter readFromFileToCharArray(String fileName) throws IOException{
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            char[] tempCharArray = new char[1024];
            int tempCountByte = 0;
            while (br.ready()) {
                tempCountByte = br.read(tempCharArray);
                charArrayWriter.write(tempCharArray, 0, tempCountByte);
            }
            return charArrayWriter;
        } catch (IOException e) {
            String message = String.format("Ошибка при чтении файла %s", fileName);
            throw new IOException(message, e);
        }
    }

    public static void writeCharArrayToFile(CharArrayWriter charArrayWriter, String fileName, boolean append, boolean addSpace) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            charArrayWriter.writeTo(bw);
            if (addSpace)
                bw.write('\n');
            bw.flush();
        } catch (IOException e) {
            String message = String.format("Ошибка при записи в файл %s", fileName);
            throw new IOException(message, e);
        }
    }

    public static boolean containsWordToFile(String fileName, String word) throws IOException {
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

    public static boolean containsWordToFiles(String[] fileNames, String word) throws IOException {
        for (int i = 0; i < fileNames.length; i++) {
            if (!containsWordToFile(fileNames[i], word))
                return false;
        }
        return true;
    }

    public static boolean containsWordToFilesInDirectory(String directory, String word) throws IOException {
        File fileDirectory = new File(directory);
        if (fileDirectory.isFile())
            return false;
        File[] filesArray = fileDirectory.listFiles();
        for (File file : filesArray) {
            if (file.isFile()) {
                if (containsWordToFile(file.getAbsolutePath(), word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addWordInFilesToDirectory(String directory, String word) throws IOException {
        File fileDirectory = new File(directory);
        if (fileDirectory.isFile()) {
            return;
        }
        File[] filesArray = fileDirectory.listFiles();
        for (File file : filesArray) {
            CharArrayWriter charArrayWriter = new CharArrayWriter(word.length());
            charArrayWriter.write(word);
            writeCharArrayToFile(charArrayWriter, file.getAbsolutePath(), true, false);
        }
    }
}
