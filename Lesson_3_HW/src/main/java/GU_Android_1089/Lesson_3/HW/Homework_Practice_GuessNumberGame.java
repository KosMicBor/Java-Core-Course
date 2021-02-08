package GU_Android_1089.Lesson_3.HW;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class Homework_Practice_GuessNumberGame {
    private static int maxValue = 9;
    private static final int zeroValue = 0;

    public static void main(String[] args) {
        // Задание 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки
        // угадать это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
        // чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        // 1 – да / 0 – нет»(1 – повторить, 0 – нет).+
        init();
    }

    /**
     * This method is used to start the game
     */
    private static void init(){
        int hiddenNumber = randomNumberGenerator();
        System.out.println("Загадано цело число от 0 до 9. Отгадаете ли Вы его за 3 попытки? Игра началась!");
        CompareNumbers(hiddenNumber);
    }
    /**
     * The Method generates random number for game
     * @return random int Number from 0 to 9
     */
    private static int randomNumberGenerator(){
        int randomValue = zeroValue;
        randomValue = (int)(Math.random()*maxValue);
        return randomValue;
    }

    /**
     * This method gets value which user inputs into the console after request
     * @return int value from console
     */
    private static int getValueFromUser (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число от 0 до 9: ");
        int userValue = sc.nextInt();

        if (userValue > maxValue || userValue < zeroValue) {
            System.out.println("Нужно вводить только числа от 0 до 9!");
            getValueFromUser();
        }
        //sc.close(); I don't understand were I should close Scanner. Explain it to me, please
        return userValue;
    }

    /**
     * This method compares user answer and generated number during 3 tries
     * @param hiddenNumber int number which was generated earlier in method randomNumberGenerator()
     */
    private static void CompareNumbers (int hiddenNumber){
        int tryCount = 3;
        int userAnswer = zeroValue;

        while (tryCount != zeroValue) {
            userAnswer = getValueFromUser();
            if (userAnswer == hiddenNumber) {
                System.out.println("Поздравляем, Вы выиграли!");
                tryAgainAsker();
                break;
            } else if (userAnswer > hiddenNumber){
                System.out.println("Загаданное число меньше Вашего");
                tryCount--;
                System.out.println("Осталось попыток: " + tryCount);
            } else if (userAnswer < hiddenNumber){
                System.out.println("Загаданное число больше Вашего");
                tryCount--;
                System.out.println("Осталось попыток: " + tryCount);
            }
        }

        if (tryCount == zeroValue){
            System.out.println("Игра проиграна, вашу удачу унёс гном!");
            tryAgainAsker();
        }
    }

    /**
     * This method is used to ask user if he/she wants to play the game or end the game.
     */
    private static void tryAgainAsker(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Хотите сыграть ещё раз? 1  да / 0 – нет\nВаш ответ: ");
        int userChoice = sc.nextInt();

        if (userChoice == 1){
            init();

        } else if (userChoice == zeroValue){
            System.exit(zeroValue);
        }
    }
}
