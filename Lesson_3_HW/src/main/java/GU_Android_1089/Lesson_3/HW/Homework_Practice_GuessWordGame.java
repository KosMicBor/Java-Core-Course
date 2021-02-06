package GU_Android_1089.Lesson_3.HW;

import java.util.Locale;
import java.util.Scanner;

public class Homework_Practice_GuessWordGame {

    public static void main(String[] args) {

        init();

    }

    private static void init(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int hiddenWordIndex = genIntValue();
        String hiddenWord = words[hiddenWordIndex];
        String userWord = getUserWord();
        CompareWords(hiddenWord, userWord);

    }

    private static int genIntValue (){
        int randomValue = 0;
        int maxValue = 24;
        randomValue = (int)(Math.random()*maxValue);
        return randomValue;
    }

    private static String  getUserWord (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String userWord = sc.nextLine();
        if (userWord == ""){
            System.out.println("Нельзя так делать! Фу-Фу-Фу таким быть! Введи слово, будь умничкой!");
            getUserWord();
        }

        return userWord;
    }

    private static void CompareWords(String OuterHiddenWord, String OuterUserWord){

        char[] arrayMatchedChars = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        int HiddenWordLength = OuterHiddenWord.length() - 1;
        OuterUserWord = OuterUserWord.toLowerCase(Locale.ROOT);
        OuterHiddenWord = OuterHiddenWord.toLowerCase(Locale.ROOT);

            while (!(OuterUserWord.equals(OuterHiddenWord))) {
                int userWordLength = OuterUserWord.length() - 1;
                for (int i = 0; i < userWordLength && userWordLength <= HiddenWordLength; i++) {

                    if (OuterUserWord.charAt(i) == OuterHiddenWord.charAt(i)) {
                        arrayMatchedChars[i] = OuterUserWord.charAt(i);
                    } else {
                        arrayMatchedChars[i] = '#';
                    }

                }

                System.out.print(arrayMatchedChars);
                System.out.println();
                OuterUserWord = getUserWord();
            }

            System.out.printf("You win! The hidden word is '%s'\n", OuterUserWord);
            tryAgainAsker();

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

        } else if (userChoice == 0){
            System.exit(0);
        }
    }
}

