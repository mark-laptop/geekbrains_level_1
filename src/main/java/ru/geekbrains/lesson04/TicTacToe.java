package ru.geekbrains.lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private final int SIZE_FIELD;
    private final int COUNT_WINNER_FIGURE;
    private final String[][] field;
    private String playerName;
    private final String DEFAULT_PLAYER_NAME = "Player";
    private final int DEFAULT_SIZE_FIELD = 3;
    private final int MAX_SIZE_FIELD = 10;
    private Figure playerFigure;
    private Figure aiFigure;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public TicTacToe(int sizeField, int countWinnerFigure) {
        if (isNotValidArguments(sizeField, countWinnerFigure))
            throw new IllegalArgumentException("Неправильно указаны размер поля или количество фишек для выигрыша");
        this.SIZE_FIELD = sizeField;
        this.COUNT_WINNER_FIGURE = countWinnerFigure;
        field = new String[SIZE_FIELD][SIZE_FIELD];
    }

    public void setPlayerName(String playerName) {
        if (playerName != null && !playerName.isEmpty())
            this.playerName = playerName;
        else
            this.playerName = DEFAULT_PLAYER_NAME;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Figure getPlayerFigure() {return playerFigure;}

    public Figure getAiFigure() {return aiFigure;}

    public void playerTurn() {
        int xCoordinate;
        int yCoordinate;
        do {
            System.out.print("Введите координаты в формате X и Y через пробел: ");
            xCoordinate = scanner.nextInt() - 1;
            yCoordinate = scanner.nextInt() - 1;
        }while (!isValidCell(xCoordinate, yCoordinate));
        field[yCoordinate][xCoordinate] = playerFigure.getSymbol();
        System.out.println();
    }

    public void aiTurn() {
        int xCoordinate;
        int yCoordinate;
        do {
            xCoordinate = random.nextInt(SIZE_FIELD);
            yCoordinate = random.nextInt(SIZE_FIELD);
        }while (!isValidCell(xCoordinate, yCoordinate));
        field[yCoordinate][xCoordinate] = aiFigure.getSymbol();
        System.out.printf("Компьютер сделал ход по координатам Х: %d и Y: %d\n", xCoordinate, yCoordinate);
    }

    private boolean isNotValidArguments(int sizeField, int countWinnerFigure) {
        if (sizeField < DEFAULT_SIZE_FIELD
                || sizeField > MAX_SIZE_FIELD
                || countWinnerFigure < DEFAULT_SIZE_FIELD
                || countWinnerFigure > MAX_SIZE_FIELD
                || countWinnerFigure > sizeField)
            return true;
        else
            return false;
    }

    public boolean isValidCell(int x, int y) {
        if ((x < 0 || x >= SIZE_FIELD) || y < 0 || y >= SIZE_FIELD)
            return false;
        if (field[y][x].equals(Figure.EMPTY_FIGURE.getSymbol()))
            return true;
        else
            return false;
    }

    public boolean checkWinner(Figure figure) {
//        if(field[0][0].equals(figure.getSymbol()) && field[0][1].equals(figure.getSymbol()) && field[0][2].equals(figure.getSymbol())) return true;
////        if(field[1][0].equals(figure.getSymbol()) && field[1][1].equals(figure.getSymbol()) && field[1][2].equals(figure.getSymbol())) return true;
////        if(field[2][0].equals(figure.getSymbol()) && field[2][1].equals(figure.getSymbol()) && field[2][2].equals(figure.getSymbol())) return true;
////
////        if(field[0][0].equals(figure.getSymbol()) && field[1][0].equals(figure.getSymbol()) && field[2][0].equals(figure.getSymbol())) return true;
////        if(field[0][1].equals(figure.getSymbol()) && field[1][1].equals(figure.getSymbol()) && field[2][1].equals(figure.getSymbol())) return true;
////        if(field[0][2].equals(figure.getSymbol()) && field[1][2].equals(figure.getSymbol()) && field[2][2].equals(figure.getSymbol())) return true;
////
////        if(field[0][0].equals(figure.getSymbol()) && field[1][1].equals(figure.getSymbol()) && field[2][2].equals(figure.getSymbol())) return true;
////        if(field[2][0].equals(figure.getSymbol()) && field[1][1].equals(figure.getSymbol()) && field[0][2].equals(figure.getSymbol())) return true;
////        return false;
        for (int indexColumn = 0; indexColumn < SIZE_FIELD - COUNT_WINNER_FIGURE + 1; indexColumn++) {
            for (int indexRow = 0; indexRow < SIZE_FIELD - COUNT_WINNER_FIGURE + 1; indexRow++) {
                if (checkDiagonal(figure, indexColumn, indexRow) || checkLine(figure, indexColumn, indexRow))
                    return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(Figure figure, int offsetX, int offsetY) {
        boolean Right = true;
        boolean Left = true;
        for (int i = 0; i < COUNT_WINNER_FIGURE; i++) {
            Right &= (field[i + offsetX][i + offsetY].trim().equals(figure.getSymbol().trim()));
            Left &= (field[COUNT_WINNER_FIGURE - i - 1 + offsetX][i + offsetY].trim().equals(figure.getSymbol().trim()));
        }
        return Right || Left;
    }

    private boolean checkLine(Figure figure, int offsetX, int offsetY) {
        for (int column = offsetX; column < COUNT_WINNER_FIGURE + offsetX; column++) {
            boolean checkColumn = true;
            boolean checkRow = true;
            for (int row = offsetY; row < COUNT_WINNER_FIGURE + offsetY; row++) {
                checkColumn &= (field[column][row].trim().equals(figure.getSymbol().trim()));
                checkRow &= (field[row][column].trim().equals(figure.getSymbol().trim()));
            }
            if (checkColumn || checkRow)
                return true;
        }
        return false;
    }

    public boolean isFieldFull() {
        for (int indexRow = 0; indexRow < SIZE_FIELD; indexRow++) {
            for (int indexColumn = 0; indexColumn < SIZE_FIELD; indexColumn++) {
                if (field[indexRow][indexColumn].equals(Figure.EMPTY_FIGURE.getSymbol()))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidAndSetFigure(String figure) {
        if (figure != null && !figure.isEmpty()) {
            if (figure.trim().equalsIgnoreCase(Figure.X.getSymbol().trim())
                    || figure.trim().equalsIgnoreCase(Figure.X.getAlternativeSymbol().trim())) {
                playerFigure = Figure.X;
                aiFigure = Figure.O;
                return true;
            }
            else if (figure.trim().equalsIgnoreCase(Figure.O.getSymbol().trim())
                    || figure.trim().equalsIgnoreCase(Figure.O.getAlternativeSymbol().trim())) {
                playerFigure = Figure.O;
                aiFigure = Figure.X;
                return true;
            }
        }
        return false;
    }

    void initField() {
        for (int indexRow = 0; indexRow < SIZE_FIELD; indexRow++) {
            for (int indexColumn = 0; indexColumn < SIZE_FIELD; indexColumn++) {
                field[indexRow][indexColumn] = Figure.EMPTY_FIGURE.getSymbol();
            }
        }
    }

    public void showField() {
        lineSeparator();
        for (int indexRow = 0; indexRow < SIZE_FIELD; indexRow++) {
            if (indexRow == 0)
                System.out.printf(" %s  ", " ");
            System.out.printf(" %d  ", indexRow + 1);
        }

        System.out.println();

        for (int indexRow = 0; indexRow < SIZE_FIELD; indexRow++) {
            System.out.printf("%-2d ", (indexRow + 1));
            for (int indexColumn = 0; indexColumn < SIZE_FIELD; indexColumn++) {
                System.out.printf("|%2s", field[indexRow][indexColumn]);
            }
            System.out.print("|");
            System.out.println();
        }
        lineSeparator();
    }

    private void lineSeparator() {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private enum Figure {
        X(" X ", " Х "),
        O(" O ", " О "),
        EMPTY_FIGURE("   ", "   ");

        private String symbol;
        private String alternativeSymbol;

        Figure(String symbol, String alternativeSymbol) {
            this.symbol = symbol;
            this.alternativeSymbol = alternativeSymbol;
        }

        private String getSymbol() {
            return symbol;
        }

        private String getAlternativeSymbol() {
            return alternativeSymbol;
        }
    }
}
