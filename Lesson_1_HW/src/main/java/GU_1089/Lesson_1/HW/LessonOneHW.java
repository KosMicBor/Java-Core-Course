package GU_1089.Lesson_1.HW;

import java.util.Scanner;

public class LessonOneHW {
    public static void main(String[] args) {
        //Задание 2. Создать переменные всех пройденных типов данных и инициализировать их значения.

        byte byteVar = -127;
        short shortVar = 500;
        int intVAr = 0;
        long longVar = 800005L;
        float floatVar = 0f;
        double doubleVar = 0;
        char charVar = '*';
        boolean booleanVar = true;
        String varChar = "Hello";

        //Задание 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        //где a, b, c, d – аргументы этого метода, имеющие тип float.

        expMethod(1.2f,2.8f,3.333333f,0.89f);

        //Задание 4. Написать метод, принимающий на вход два целых числа и проверяющий,
        //что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

        boolean compareResult = getCompareResult();
        if (compareResult == true){
            System.out.println("Задание 4: сумма чисел лежит в заданных пределах от 10 до 20");
        } else {
            System.out.println("Задание 4: сумма чисел лежит вне заданных пределов (от 10 до 20)");
        }

        //Задание 5. Написать метод, которому в качестве параметра передается целое число,
        //метод должен напечатать в консоль, положительное ли число передали или отрицательное.
        //Замечание: ноль считаем положительным числом.

        int valFromConsole = getIntValFromConsole();
        moreOrLess(valFromConsole);

        //Задание 6. Написать метод, которому в качестве параметра передается целое число.
        //Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

        int exSixIntValue = getIntValFromConsole();
        System.out.println("Задание 6: Число орицательное? " + isItNegative(exSixIntValue));

        //Задание 7. Написать метод, которому в качестве параметра передается строка,
        //обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».

        String someName = getNameFromConsole();
        printWelcomeMethod(someName);

        //Задание 8. *Написать метод, который определяет,
        //является ли год високосным, и выводит сообщение в консоль.
        //Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

        System.out.println("Задание 8: Високоный ли год?");
        int yearVar =  getIntValFromConsole();
        isYearLeap(yearVar);

    }
    // Задание 3.
    public static void expMethod(float a, float b, float c, float d){
        System.out.println("Задание № 3. a * (b + (c / d)) = " + a * (b + (c / d)));
    }
    // Задание 4.
    public static boolean getCompareResult () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число А: ");
        int valA = in.nextInt();
        System.out.print("Введите число B: ");
        int valB = in.nextInt();
        boolean compResult = summIsInRange(valA, valB);
        return compResult;
    }

    public static boolean summIsInRange (int aVal, int bVal) {
        int summ = aVal + bVal;
        if(summ >= 10 && summ <= 20){
            return true;
        } else{
            return false;
        }
    }

    // Задание 5.
    public static void moreOrLess(int exFiveValue){
        if (exFiveValue < 0){
            System.out.println("Задание 5: получено отрицательное число");
        } else if (exFiveValue >= 0){
            System.out.println("Задание 5: получено положительное число");
        } else {
            System.out.println("Задание 5: получено вообще не число");
        }
    }

    // Задание 6
    public static boolean isItNegative(int valFromUser){
        if (valFromUser < 0){
            return true;
        } else {
            return false;
        }
    }

    // Задание 7
    public static void printWelcomeMethod(String someName){
        System.out.println("Привет, " + someName);
    }
    
    // Задание 8
    public static void isYearLeap(int yearVar){
        if (yearVar%100 != 0 && yearVar%4 == 0 || yearVar%400 == 0){
            System.out.println("Этот год високосный");
        } else {
            System.out.println("Этот год не високосный");
        }
    }

    // методы считывания данных из консоли для примеров

    public static int getIntValFromConsole(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = in.nextInt();
        return a;
    }
    public static String getNameFromConsole(){
        Scanner in = new Scanner(System.in);
        System.out.print("Задание 6. Введите имя: ");
        String name = in.nextLine();
        return name;
    }
}
