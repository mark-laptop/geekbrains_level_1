package ru.geekbrains.lesson07;

import java.io.*;

public class WorkForFiles {

    public static void mergeFilesToNewFile(String[] fileNames, String fileTo) throws IOException {
        File[] files = new File[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            files[i] = new File(fileNames[i]);
        }
        mergeFilesToNewFile(files, new File(fileTo));
    }

    public static void mergeFilesToNewFile(File[] files, File fileTo) throws IOException {
        for (File file : files) {
            writeFileToNewFile(file, fileTo, true, true);
        }
    }

    public static void writeFileToNewFile(File fileFrom, File fileTo) throws IOException {
        writeFileToNewFile(fileFrom, fileTo, false, false);
    }

    public static void writeFileToNewFile(File fileFrom, File fileTo, boolean append) throws IOException {
        writeFileToNewFile(fileFrom, fileTo, append, false);
    }

    public static void writeFileToNewFile(File fileFrom, File fileTo, boolean append, boolean addBreakLine) throws IOException {

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileFrom));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileTo, append))) {

            byte[] buffer = new byte[2048];
            int rawByteCount = 0;
            while (bufferedInputStream.available() > 0) {
                rawByteCount = bufferedInputStream.read(buffer);
                bufferedOutputStream.write(buffer, 0, rawByteCount);
            }
            if (addBreakLine)
                bufferedOutputStream.write('\n');
            bufferedOutputStream.flush();

        } catch (IOException e) {
            String message = String.format("При записи данных из файла %s в файл %s произошла ошибка"
                    , fileFrom.getAbsolutePath()
                    , fileTo.getAbsolutePath());
            throw new IOException(message, e);
        }
    }

    public static boolean containsStringToFilesDirectory(String directory, String words) throws IOException {
        return containsStringToFilesDirectory(new File(directory), words);
    }

    public static boolean containsStringToFilesDirectory(File directory, String words) throws IOException {
        boolean result = false;

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                result = containsStringToFile(file, words);
                if (result)
                    break;
            }
        } else {
            result = containsStringToFile(directory, words);
        }
        return result;
    }

    public static boolean containsStringToFile(File file, String words) throws IOException {
        boolean result = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            while (bufferedReader.ready()) {
                if (bufferedReader.readLine().contains(words)) {
                    result = true;
                    break;
                }
            }

        } catch (IOException e) {
            String message = String.format("При чтении данных из файла %s произошла ошибка", file.getAbsolutePath());
            throw new IOException(message, e);
        }
        return result;
    }

    public static void appendStringToEndFileInDirectory(String directory, String words) throws IOException {
        appendStringToEndFileInDirectory(directory, words, false);
    }

    public static void appendStringToEndFileInDirectory(String directory, String words, boolean deepPass) throws IOException {
        appendStringToEndFileInDirectory(new File(directory), words, deepPass);
    }

    public static void appendStringToEndFileInDirectory(File directory, String words) throws IOException {
        appendStringToEndFileInDirectory(directory, words, false);
    }

    public static void appendStringToEndFileInDirectory(File directory, String words, boolean deepPass) throws IOException {

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory() && deepPass) {
                appendStringToEndFileInDirectory(file, words, deepPass);
            }
            appendStringToEndFile(file, words);
        }
    }

    public static void appendStringToEndFile(String file, String words) throws IOException {
        appendStringToEndFile(file, words, false);
    }

    public static void appendStringToEndFile(String file, String words, boolean addBreakLine) throws IOException {
        appendStringToEndFile(new File(file), words, addBreakLine);
    }

    public static void appendStringToEndFile(File file, String words) throws IOException {
        appendStringToEndFile(file, words, false);
    }

    public static void appendStringToEndFile(File file, String words, boolean addBreakLine) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            if (addBreakLine)
                bufferedOutputStream.write('\n');
            bufferedOutputStream.write(words.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            String message = String.format("При записи строки в файл %s произошла ошибка", file.getAbsolutePath());
            throw new IOException(message, e);
        }
    }
}
