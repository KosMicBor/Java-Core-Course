package GU_Android_1089.Lesson_4.Homework;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE_3 = 3;
    private static final int SIZE_5 = 5;
    private static int SIZE;
    private static final int ZERO = 0;
    private static final int valueOne = 1;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_O = 'O';
    private static final char DOT_X = 'X';
    private static char[][] map;
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        choiceOfDifficulty();
        initMap();
        drawMap();

        while (true) {
            humanTurn();

            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }

            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();

            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }

            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }


        }
    }

    /**
     * This method helps user to choose the difficulty
     */
    private static void choiceOfDifficulty() {

        do {
            System.out.printf("Выберите уровень сложности:%n3 - поле 3х3%n5 - поле 5x5%n");
            SIZE = sc.nextInt();
        } while (SIZE != SIZE_3 && SIZE != SIZE_5);

    }

    /**
     * The method initialize game's map - fills it with '•'
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = ZERO; i < SIZE; i++) {

            for (int j = ZERO; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }

        }
    }

    /**
     * This method draws game's map
     */
    private static void drawMap() {

        for (int i = ZERO; i <= SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = ZERO; i < SIZE; i++) {
            System.out.print(i + valueOne + " ");
            for (int j = ZERO; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method gets coordinates x, y of 'X' from user
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Ваш ход! Введите координаты X и Y:");
            x = sc.nextInt() - valueOne;
            y = sc.nextInt() - valueOne;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
        drawMap();
        System.out.println();
    }

    /**
     *  This method makes AI to make a step and prevent user's victorious step
     */
    private static void aiTurn() {
        int x, y;
        boolean isHorPrevent = false;
        boolean isVerPrevent = false;
        boolean isLDiagPrevent = false;
        boolean isRDiagPrevent = false;

        isHorPrevent = preventWinHorizontal();

        if (!isHorPrevent) {
            isVerPrevent = preventWinVertical();
        }

        if (!isHorPrevent && !isVerPrevent) {
            isLDiagPrevent = preventWinLDiag();
        }

        if (!isHorPrevent && !isVerPrevent && !isLDiagPrevent) {
            isRDiagPrevent = preventWinRDiag();
        }

        if (!isHorPrevent && !isVerPrevent && !isLDiagPrevent && !isRDiagPrevent) {

            do {
                x = (int) (Math.random() * (SIZE));
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));

            map[x][y] = DOT_O;
        }

        drawMap();
        System.out.println();
    }

    /**
     * The method checks if the nest AI's or user's step is correct
     * @param x x coordinate from next step
     * @param y y coordinate from next step
     * @return true of step is correct
     */
    private static boolean isCellValid(int x, int y) {

        if (x < ZERO || x >= SIZE || y < ZERO || y >= SIZE) {
            System.out.println("Некорректные координаты");
            return false;
        } else if (map[y][x] == DOT_EMPTY) {
            return true;
        }

        return false;
    }

    /**
     * The method checks winning combination of symbols 'X' or 'O'
     * @param symbol it is the 'X' or 'O' char from user's or AI's step
     * @return true if it is win situation
     */
    private static boolean checkWin(char symbol) {
        int counterHor = ZERO;
        int counterVer = ZERO;
        int counterLDiag = ZERO;
        int counterRDiag = ZERO;
        int winSize = SIZE_3;

        if (SIZE == SIZE_3) {

            for (int i = ZERO; i < SIZE; i++) {
                for (int j = ZERO, k = SIZE - valueOne; j < SIZE && k >= ZERO; j++, k--) {

                    if (map[i][j] == symbol) {
                        ++counterHor;
                    }

                    if (map[j][i] == symbol) {
                        ++counterVer;
                    }

                    if (map[j][j] == symbol) {
                        ++counterLDiag;
                    }

                    if (map[j][k] == symbol) {
                        ++counterRDiag;
                    }
                }

                if (counterHor == winSize || counterVer == winSize || counterLDiag == winSize || counterRDiag == winSize) {
                    return true;
                }

                counterHor = ZERO;
                counterVer = ZERO;
                counterLDiag = ZERO;
                counterRDiag = ZERO;
            }
        }else if (SIZE == SIZE_5) {
            for (int offsetX = 0; offsetX < SIZE_5 - SIZE_3; offsetX++){
                for (int offsetY = 0; offsetY < SIZE_5 - SIZE_3; offsetY++){
                    if (checkWin5Size(offsetX, offsetY, symbol)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * The method checks if map is full
     * @return true if map is full
     */
    private static boolean checkFull() {

        for (int i = ZERO; i < SIZE; i++) {

            for (int j = ZERO; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * The method prevent user's horizontally winning step
     * @return true if winning step prevented
     */
    private static boolean preventWinHorizontal(){
        int x = ZERO, y = ZERO;
        int counterX = ZERO;
        int almostWin = SIZE - valueOne;

        for (int i = ZERO; i < SIZE; i++) {

            for (int j = ZERO; j < SIZE; j++) {

            if (map[i][j] == DOT_X){
                    counterX++;
                }

                if (map[i][j] == DOT_EMPTY) {
                    x = i;
                    y = j;
                }

            }

            if (counterX == almostWin && isCellValid(y, x)){
                map[x][y] = DOT_O;
                return true;
            }

            counterX = ZERO;
        }
        return false;
    }

    /**
     * The method prevent user's vertically winning step
     * @return true if winning step prevented
     */
    private static boolean preventWinVertical(){
        int x = ZERO, y = ZERO;
        int counterX = ZERO;
        int almostWin = SIZE - valueOne;

        for (int i = ZERO; i < SIZE; i++) {

            for (int j = ZERO; j < SIZE; j++) {

                if (map[j][i] == DOT_X){
                    counterX++;
                }

                if (map[j][i] == DOT_EMPTY) {
                    x = j;
                    y = i;
                }

            }

            if (counterX == almostWin && isCellValid(y, x)){
                map[x][y] = DOT_O;
                return true;
            }

            counterX = ZERO;
        }
        return false;
    }

    /**
     * The method prevent user's left diagonal winning step
     * @return true if winning step prevented
     */
    private static boolean preventWinLDiag(){
        int x = ZERO, y = ZERO;
        int counterX = ZERO;
        int almostWin = SIZE - valueOne;

        for (int i = ZERO; i < SIZE; i++) {

            if (map[i][i] == DOT_X){
                counterX++;
            }

            if (map[i][i] == DOT_EMPTY) {
                x = i;
                y = i;
            }

        }

        if (counterX == almostWin && isCellValid(x, y)){
            map[x][y] = DOT_O;
            return true;
        }

        return false;
    }

    /**
     * The method prevent user's right diagonal winning step
     * @return true if winning step prevented
     */
    private static boolean preventWinRDiag(){
        int x = ZERO, y = ZERO;
        int counterX = ZERO;
        int almostWin = SIZE - valueOne;

       for (int i = ZERO, j = SIZE - valueOne; i < SIZE && j >= ZERO; i++, j--) {

                if (map[i][j] == DOT_X){
                    counterX++;
                }

                if (map[j][j] == DOT_EMPTY) {
                    x = j;
                    y = i;
                }

            }

            if (counterX == almostWin && isCellValid(y, x)){
                map[x][y] = DOT_O;
                return true;
            }


        return false;
    }

     /**
     * The method checks winning combination of symbols 'X' or 'O' if the map is 5x5
     * @param offsetX it is the offset for x coordinate, which displaces checking square by x axis
     * @param offsetY it is the offset for y coordinate, which displaces checking square by y axis
     * @param symbol it is the 'X' or 'O' char from user's or AI's step
     * @return true if it is win situation
     */
    private static boolean checkWin5Size(int offsetX, int offsetY, char symbol){
        int counterHor = ZERO;
        int counterVer = ZERO;
        int counterLDiag = ZERO;
        int counterRDiag = ZERO;
        int winSize = SIZE_5 - valueOne;

        for (int i = offsetX; i < winSize + offsetX; i++) {

            for (int j = offsetY, k = winSize - valueOne + offsetY; j < SIZE + offsetY && k >= offsetY; j++, k--) {

                if (map[i][j] == symbol) {
                    ++counterHor;
                }

                if (map[j][i] == symbol) {
                    ++counterVer;
                }

                if (map[j][j] == symbol) {
                    ++counterLDiag;
                }

                if (map[j][k] == symbol) {
                    ++counterRDiag;
                }
            }

            if (counterHor == winSize || counterVer == winSize || counterLDiag == winSize || counterRDiag == winSize) {
                return true;
            }

            counterHor = ZERO;
            counterVer = ZERO;
            counterLDiag = ZERO;
            counterRDiag = ZERO;
        }
        return false;
    }
}
