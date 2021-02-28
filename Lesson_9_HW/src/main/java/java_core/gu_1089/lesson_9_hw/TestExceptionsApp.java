package java_core.gu_1089.lesson_9_hw;

import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

import java.util.Random;

public class TestExceptionsApp {
    private static final int VAL_1 = 1;
    private static final int VAL_0 = 0;
    private static int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] stringArray = new String[ARRAY_SIZE][ARRAY_SIZE];
        stringArray = fillArray(stringArray);


        for (int i = 0; i < stringArray.length; i++){
            for (int j = 0; j < ARRAY_SIZE; j++){
                System.out.print(stringArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        try {
            convertAndSumArray(stringArray);
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
    }

    /**
     * This method adds numbers from myArray
     * @param myArray some outer two-dimensional array
     * @throws MyArraySizeException Exception if array size is not as sets in restriction
     * @throws MyArrayDataException Exception if value is not Integer
     */
    private static void convertAndSumArray(String[][] myArray) throws MyArraySizeException, MyArrayDataException {
        final int arraySizeRestriction = 4;
        int sum = VAL_0;
        int currentArrayValue;

        if (myArray.length != arraySizeRestriction){
            throw new MyArraySizeException(String.format("Задана неверная длина массива"));
        }

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {

                try {
                    currentArrayValue = Integer.valueOf(myArray[i][j]);
                    sum += currentArrayValue;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                        String.format("Неверный символ в строке %d, ячейка %d\n", i+VAL_1, j+VAL_1)
                    );
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * The method returns random string from specified array
     * @param maxValue max value of range in which method generates number
     * @return random string
     */
    private static int genRandomValue(int maxValue){
        Random r = new Random();
        return r.nextInt(maxValue);
    }

    /**
     * The method fills outer two-dimensional array with random strings
     * @param someArray some outer two-dimensional array
     * @return filled two-dimensional array
     */
    private static String[][] fillArray(String[][] someArray){
        String[] symbolsArray = {"!", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int maxSymbolQuantity = symbolsArray.length - VAL_1;

        for (int i = 0; i < someArray.length; i++){
            for (int j = 0; j < someArray.length; j++){
                someArray[i][j] = symbolsArray[genRandomValue(maxSymbolQuantity)];
            }
        }
        return someArray;
    }
}
