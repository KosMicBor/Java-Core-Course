package java_core.gu_1089.lesson_7_hw;

public class FeedingCatApp {
    public static void main(String[] args) {
    Cat firstCat = new Cat("Fluffy", 5);
    Plate publicPlate = new Plate(110);

    firstCat.eat(publicPlate);

    System.out.println("=================================");

    Cat[] catsArray = new Cat[5];
        catsArray[0] = new Cat("Kitty", 15);
        catsArray[1] = new Cat("Jackson", 30);
        catsArray[2] = new Cat("Bubble", 50);
        catsArray[3] = new Cat("Misty", 10);
        catsArray[4] = new Cat("Kitty", 10);

        for (Cat elem: catsArray) {
            elem.eat(publicPlate);
            System.out.println(elem.getSatiety());
        }

    publicPlate.addFood(100);

    }
}
