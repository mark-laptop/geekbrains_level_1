package ru.geekbrains.lesson04;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(4, 4);
        ticTacToe.initField();
        changePlayerName(ticTacToe);
        gameLoop(ticTacToe);
        ticTacToe.getScanner().close();
    }

    public static void gameLoop(TicTacToe ticTacToe) {
        while (true) {
            changePlayerFigure(ticTacToe);
            ticTacToe.initField();
            ticTacToe.showField();
            while (true) {
                ticTacToe.playerTurn();
                ticTacToe.showField();
                // проверка
                if (ticTacToe.checkWinner(ticTacToe.getPlayerFigure())) {
                    System.out.println("Вы победили!");
                    break;
                }
                if (ticTacToe.isFieldFull()) {
                    System.out.println("Ничья!");
                    break;
                }
                ticTacToe.aiTurn();
                ticTacToe.showField();
                // проверка
                if (ticTacToe.checkWinner(ticTacToe.getAiFigure())) {
                    System.out.println("Вы проиграли!");
                    break;
                }
                if (ticTacToe.isFieldFull()) {
                    System.out.println("Ничья!");
                    break;
                }
            }
            System.out.print("Хотите сыграть еще раз! Если да введите Д, если нет введите Н: ");
            ticTacToe.getScanner().nextLine();
            String userAnswer = ticTacToe.getScanner().nextLine();
            if ("Д".equalsIgnoreCase(userAnswer) || "Y".equalsIgnoreCase(userAnswer))
                continue;
            else if ("Н".equalsIgnoreCase(userAnswer) || "N".equalsIgnoreCase(userAnswer))
                break;
        }
    }

    public static void changePlayerName(TicTacToe ticTacToe) {
        System.out.print("Крестики-Нолики!!!\nВведите ваше имя: ");
        ticTacToe.setPlayerName(ticTacToe.getScanner().nextLine());
        System.out.printf("Приветствую %s!\n", ticTacToe.getPlayerName());
    }

    public static void changePlayerFigure(TicTacToe ticTacToe) {
        String playerFigure = null;
        do {
            System.out.print("Выберите свою фишку: для X введите X, для O введите O: ");
            playerFigure = ticTacToe.getScanner().nextLine();
        } while (!ticTacToe.isValidAndSetFigure(playerFigure));
    }
}
