package GU_Android_1089.lesson_6.homework;

public class AnimalApp {
    public static void main(String[] args) {
        Cat funnyCat = new Cat("Пушистик", "Белый");
        Cat fatCat = new Cat("Bubbles", "Orange");
        Dog littleDog = new Dog ("Бобик", "Чёрный");
        funnyCat.run(198);
        funnyCat.swim(15);
        fatCat.run(500);
        littleDog.run(300);
        littleDog.swim(10);
        fatCat.getAnimalsQuantity();
        funnyCat.getCatsQuantity();
        littleDog.getDogsQuantity();
    }
}
