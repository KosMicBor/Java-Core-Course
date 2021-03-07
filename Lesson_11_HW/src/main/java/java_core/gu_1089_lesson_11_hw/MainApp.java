package java_core.gu_1089_lesson_11_hw;

import java_core.gu_1089_lesson_11_hw.Boxes.Box;
import java_core.gu_1089_lesson_11_hw.fruit.Apple;
import java_core.gu_1089_lesson_11_hw.fruit.Fruit;
import java_core.gu_1089_lesson_11_hw.fruit.Orange;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        final int ZERO_VAL = 0;

        int arrayOfFruitsSize = 5;
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C", "D"};
        int[] primitiveIntArray = {1, 2, 3, 4, 5};

        /*1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);*/

        swapArrElem switchIntArray = new swapArrElem(intArray);
        swapArrElem switchStrArray = new swapArrElem(strArray);

        System.out.println(switchIntArray.switchArrayElements(1, 4));
        System.out.println(switchStrArray.switchArrayElements("B", "D"));

        /*2. Написать метод, который преобразует массив в ArrayList;*/
        System.out.println(arrayToList(strArray));

        /*Задача:
        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        Класс Box, в который можно складывать фрукты. Коробки условно
        сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Для хранения фруктов внутри коробки можно использовать ArrayList;
        Сделать метод getWeight(), который высчитывает вес коробки,
        зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
        которую подадут в compare() в качестве параметра. true – если их массы равны,
        false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        Не забываем про метод добавления фрукта в коробку.
        */
        ArrayList<Apple> someApples = new ArrayList<>();

        for (int i = ZERO_VAL; i < arrayOfFruitsSize; i++) {
            someApples.add(new Apple(i));
        }

        ArrayList<Orange> someOranges = new ArrayList<>();

        for (int i = ZERO_VAL; i < arrayOfFruitsSize; i++) {
            someOranges.add(new Orange(i));
        }

        Box firstBox = new Box(1, someApples);
        Box secondBox = new Box(2, someOranges);
        Box thirdBox = new Box(3, new ArrayList<>());

        System.out.println(firstBox);

        firstBox.add(new Orange(11));
        firstBox.add(new Apple(11));

        firstBox.printWeight();
        secondBox.printWeight();
        firstBox.compareTo(secondBox);
        secondBox.compareTo(firstBox);
        System.out.println("Пересыпем фрукты из одной коробки в другую.");
        firstBox.pourMethod(thirdBox);
        System.out.println("Это коробка откуда пересыпали: '" + firstBox + "' Она пуста.");
        System.out.println("Это коробка куда пересыпают " + thirdBox);
        firstBox.add(new Apple(12));
        System.out.println("Кладём в первую коробку ещё одно яблоко: " + firstBox);
    }

    private static <T> ArrayList<T> arrayToList(T[] array) throws NullPointerException{
        ArrayList<T> resArrList = new ArrayList<>();
        int arrSize = array.length;

        for (int i = 0; i < arrSize; i++) {
            resArrList.add(array[i]);
        }

        return resArrList;
    }
}
