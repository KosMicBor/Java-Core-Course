package java_core.gu_1089.lesson_10;

import my_classes.Duplicates;
import my_classes.Phonebook;

import java.util.Iterator;

public class MainApp {
    private static final int MAX_ARR_SIZE = 20;

    public static void main(String[] args) {

        /*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
          Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
          Посчитать, сколько раз встречается каждое слово.*/

        String[] superHeroes = {"Iron Man", "Vision", "Capitan America", "Black Panther",
                "Halk", "Halk", "Black Widow", "Hawk Eye", "Thor",
                "Iron Man", "Ant-man", "Spider-Man", "Winter Soldier",
                "Star Lord", "Thor", "Rocket Racoon", "Halk", "Mercury",
                "Miss Marvel", "Iron Man"
        };
        Duplicates duplicates = new Duplicates();
        duplicates.countDuplicates(superHeroes, MAX_ARR_SIZE);
        System.out.println(duplicates.CheckAndRemoveDuplicates(superHeroes, MAX_ARR_SIZE));
        System.out.printf("%nЗадание № 2%n");

        /*Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
          В этот телефонный справочник с помощью метода add() можно добавлять записи,
          а с помощью метода get() искать номер телефона по фамилии. Следует учесть,
          что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
          тогда при запросе такой фамилии должны выводиться все телефоны.
          Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
          взаимодействие с пользователем через консоль и т.д).
          Консоль использовать только для вывода результатов проверки телефонного справочника.*/

        String[] lastNames = {"Ivanov", "Petrov", "Sidorov", "Ivanov", "Volkov"};
        Long[] phoneNumbers = {89456132587L, 89456453147L, 89456213474L, 89654674646L, 89995422345L};
        Phonebook phonebook = new Phonebook();

        for (int i = 0; i < lastNames.length; i++) {
            phonebook.add(lastNames[i], phoneNumbers[i]);
        }

        System.out.println(phonebook.toString());
        System.out.println("Персонально у Волкова вот такой красивый номер: " + phonebook.get("Volkov"));
    }
}
