package GU_1089.Lesson_2.HW;

import java.util.Arrays;

public class LessonTwoHW {

    public static void main(String[] args) {

        //Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        //Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] arrBinary = {0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0};

        System.out.println("Массив до инверсии: " + Arrays.toString(arrBinary));
        System.out.print("Результат инверсии массива: ");
        changeArrValues(arrBinary);

        //Задание 2. Задать пустой целочисленный массив размером 8.
        //С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int [] arrForFilling = new int [8];
        int [] filledArray = {0, 3, 6, 9, 12, 15, 18, 21};

        System.out.print("Результат заполнения массива: ");
        fillingIntArrWithData(arrForFilling, filledArray);


        //Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        //и числа меньшие 6 умножить на 2;

        int[] arrayWithSomeNumbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printSimpleIntArray(arrayWithSomeNumbers);
        System.out.print("результат умножения чисел в массиве по условию 'числа меньшие 6 умножить на 2': ");
        checkAndMultiply(arrayWithSomeNumbers);


        //Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        //и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        int[][] quadArray = new int[6][6];
        fillQuadArray(quadArray);

        //Задание 5.** Задать одномерный массив и найти в нем минимальный и максимальный элементы
        //(без помощи интернета);

        minMaxValInArray();

        //Задание 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        //Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        //граница показана символами ||, эти символы в массив не входят.

        int[] arrayForChecking = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Есть баланс в массиве?: " + checkArrayBalance(arrayForChecking));

        //Задание 7. **** Написать метод, которому на вход подается одномерный массив и число n (может
        //быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        //Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        //Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
        //при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
        int[] arrayForOffset = {1, 2, 3, 4};
        int offsetValue = -3;
        setOffsetInArray(arrayForOffset, offsetValue);

        for (int i= 0; i < arrayForOffset.length; i++) {
            System.out.print(arrayForOffset[i] + " ");
        }

    }

    //Задаине 1.
    /**
     * This method inverts binary values of outer array
     * @param arrForInverse integer one-dimensional array
     */
    private static void changeArrValues (int[] arrForInverse){
        int arrLength = arrForInverse.length;
        int binaryOne = 1;
        int binaryZero = 0;

        for (int i = 0; i < arrLength; i++) {

            if (arrForInverse[i] == binaryOne){
                arrForInverse[i] = binaryZero;
            } else {
                arrForInverse[i] = binaryOne;
            }

        }

        printSimpleIntArray(arrForInverse);
    }

    /**
     * This method fills empty array with numbers
     * Another way to copy the array is System.arraycopy()
     * @param arrForFilling the empty outer array type of Integer
     * @param filledArray previously filled array with values for filling "arrForFilling"
     */
    private static void fillingIntArrWithData(int[] arrForFilling, int[] filledArray) {
        int arrForFillingLength = arrForFilling.length;

        for (int i = 0; i < arrForFillingLength; i++){
            arrForFilling[i] = filledArray[i];
        }

        printSimpleIntArray(arrForFilling);
    }

    //Задание 3

    /**
     * This method multiply by 2 all array values with are less than 6 and then print them into the console
     * @param arrayWithNumbers some array with integer values
     */
    private static void checkAndMultiply(int[] arrayWithNumbers){

        for (int num: arrayWithNumbers){
            if (num < 6) {
                num *= 2;
            }
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //Задание 4

    /**
     * The method prints an array with diagonal offset
     * @param quadArray two-dimensional array for filling
     */
    private static void fillQuadArray (int[][] quadArray){
        int diagonalValue = 1;

        for (int i = 0, k = 5; i < quadArray.length && k > -1; ++i, --k){
            quadArray[i][i] = diagonalValue;
            quadArray[i][k] = diagonalValue;
            for (int j = 0; j < quadArray[i].length; j++){
                System.out.print(quadArray[i][j] + " ");
            }

            System.out.println();
        }
    }

    //Задание 5

    /**
     * The method defines min and max values of the array and prints them into the console
     */
    private static void minMaxValInArray(){
        int[] someArray = {40, 2, 54, 48, 100, 3, 5};
        int minValue = someArray[0];
        int maxValue = someArray[0];
        int someArrayLength = someArray.length;

        for (int i = 0; i < someArrayLength; ++i){

            if (someArray[i] > maxValue){
                maxValue = someArray[i];
            }

            if (someArray[i] < minValue){
                minValue = someArray[i];
            }

        }
        System.out.println("Минимальное значение: " + minValue + "\nМаксимальное значение: " + maxValue);
    }

    // Задание 6. Прошу дать комментарий, как это можно сделать по человечески.

    /**
     * This method checks if there is the balance in the array
     * @param arrayForChecking some Integer outer array
     * @return true if there is the balance and false if there is no balance
     */
    private static boolean checkArrayBalance(int[] arrayForChecking){
        int arrayLength = arrayForChecking.length;
        int x = 0;
        int y = 0;
        int z = 0;

        for (int i = 0; i < arrayLength; i++) {
            x = x + arrayForChecking[i];

            for(int j = (arrayLength-1); j > i; j--){
                y = y +arrayForChecking[j];
            }

            if (x == y){
                return true;
            }
            y = 0;
        }

        return false;
    }

    //Задание 7

    /**
     * This method shifts array as many times as it is set in offsetValue
     * @param arrayForOffset some outer array with int values
     * @param offsetValue the offset value
     */
    private static void setOffsetInArray (int[] arrayForOffset, int offsetValue){

        if ((arrayForOffset == null) || (arrayForOffset.length == 0 )) {
            System.out.println("у вас пустой массив, батенька!");;
        }

        final int unnecessaryIndex = 1;
            int buffer = 0;
            if (offsetValue == 0){
                System.out.println("Смещения нет, т.к. ноль это не смещение");
            } else if ( offsetValue > 0) {
                while (offsetValue > 0) {
                    buffer = arrayForOffset[arrayForOffset.length - unnecessaryIndex];

                    for (int i = 0; i < arrayForOffset.length; i++) {

                        int thisElem = arrayForOffset[i];
                        arrayForOffset[i] = buffer;
                        buffer = thisElem;

                    }
                    offsetValue--;
                }

            } else if (offsetValue < 0) {
                int zeroValue = 0;

                while (offsetValue < 0) {
                    buffer = arrayForOffset[zeroValue];

                    for (int i = arrayForOffset.length - unnecessaryIndex; i >= 0; i--) {

                        int thisElem = arrayForOffset[i];
                        arrayForOffset[i] = buffer;
                        buffer = thisElem;

                    }
                    offsetValue++;
                }
            }
    }

    // Прочее
    /**
     * method prints to the console any integer one-dimensional array
     * @param anySimpleIntArray integer one-dimensional array
     */
    private static void printSimpleIntArray (int [] anySimpleIntArray) {
        System.out.println(Arrays.toString(anySimpleIntArray));
    }
}
