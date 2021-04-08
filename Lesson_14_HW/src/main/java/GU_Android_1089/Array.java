package GU_Android_1089;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    private static final int FOUR_VALUE = 4;
    private static final int OME_VALUE = 1;

    public static void main(String[] args) {
        int[] arrForExOne = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Integer[] arrForExTwo = {1, 1, 4, 4, 1, 4, 4, 1, 1};
        int[] newArray = after4ReturnMethod(arrForExOne);

        for (int j : newArray) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println(isArrayContains1And4(arrForExTwo));
    }

    //Задание 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    //Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    //идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    //иначе в методе необходимо выбросить RuntimeException.
    //Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    protected static int[] after4ReturnMethod (int[] outerArray){
        int after4Index = 0;
        int after4ArraySize;

        try {
            for (int i = 0; i < outerArray.length; i++) {
                if (outerArray[i] == FOUR_VALUE) {
                    after4Index = i + OME_VALUE;
                }
            }

            if (after4Index == 0){
                throw new RuntimeException("В массиве должна быть хотя бы одна 4");
            }

        } catch (RuntimeException e){
            e.printStackTrace();
        }

        after4ArraySize = outerArray.length - after4Index;

        int[] newArray = new int[after4ArraySize];

        System.arraycopy(outerArray, after4Index, newArray, 0, after4ArraySize);

        return newArray;
    }

    //Задание 2. Написать метод, который проверяет состав массива из чисел 1 и 4.
    //Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    //Написать набор тестов для этого метода (по 3-4 варианта входных данных).

    protected static boolean isArrayContains1And4(Integer[] someArray){
        List<Integer> arrayForChecking = new ArrayList<>(Arrays.asList(someArray));

        return arrayForChecking.contains(4) && arrayForChecking.contains(1);

    }
}
