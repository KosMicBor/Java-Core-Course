package GU_Android_1089;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ArrayTest {

    @BeforeEach
    public void init() {
        Array array = new Array();
    }

    //Тестирование для Задания 1 (простые).

    @Test
    public void testArray1() {
        Assertions.assertArrayEquals (new int[]{1, 7},Array.after4ReturnMethod (new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void testArray2() {
        Assertions.assertArrayEquals (new int[]{2, 3, 3, 1, 7},
                Array.after4ReturnMethod (new int[]{1, 2, 4, 4, 2, 3, 3, 1, 7}));
    }

    @Test
    public void testArray3() {
        Assertions.assertArrayEquals (new int[]{2, 1, 3, 0, 1, 7},
                Array.after4ReturnMethod (new int[]{4, 2, 1, 3, 0, 1, 7}));
    }

    @Test
    public void testArray4() {
        Assertions.assertArrayEquals (new int[]{1, 2, 1, 7},Array.after4ReturnMethod(new int[]{1, 2, 1, 7}));
    }

    @Test
    public void testArray5() {
        Assertions.assertArrayEquals (new int[]{},Array.after4ReturnMethod(new int[]{1, 2, 1, 4}));
    }

    //Тестирование для задания 2. Работают не до конца корректно, но так и не смог понять почему Stream ругается и
    //как это исправить (ниже 2 способа - один отказывается работать, хотя по алгоритму всё верно на мой взгяд;
    // второй работает, но при провале теста опять появляются ошибки от Stream. Как с этим бороться, не ясно,
    // подскажите, пожалуйста.).

    /* Поясните, подалуйста, почему этот метод не работает? Почему я в Stream не могу передать массив массивов?
     @ParameterizedTest
    @MethodSource("dataForCheckingOperation")
    public void testIsArrayContainsOperation(Integer[] testingArray) {
        Assertions.assertTrue(Array.isArrayContains1And4(testingArray));
    }*/

    /*public static Stream<Integer[]> dataForCheckingOperation() {
        List<Integer[]> arrayStream = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayStream.add(generateArray());
        }

        return arrayStream.stream();
    }

    private static Integer[] generateArray(){
        Integer[] array = new Integer[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            array[i] = random.nextBoolean() ? 1 : 4;
        }

        return array;
    }*/

    @ParameterizedTest
    @MethodSource("dataForCheckOperation")
    public void testIsArrayContainsOperation(int a, int b, int c,int d ,int e) {
        Integer[] testingArray = {a, b, c, d, e};
        Assertions.assertTrue(Array.isArrayContains1And4(testingArray));
    }

    public static Stream<Arguments> dataForCheckOperation() {
        List<Arguments> out = new ArrayList<>();
        int a, b, c, d, e;
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            a = random.nextBoolean() ? 1 : 4;
            b = random.nextBoolean() ? 1 : 4;
            c = random.nextBoolean() ? 1 : 4;
            d = random.nextBoolean() ? 1 : 4;
            e = random.nextBoolean() ? 1 : 4;
            out.add(Arguments.arguments(a, b, c, d, e));
        }

        return out.stream();
    }


}
