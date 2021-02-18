package java_core.gu_1089.lesson_7_hw;

public class Plate {
    private int food;

    public Plate (int food){
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food = food;
    }

    public void decreaseFood (int catsAppetite){
        food -= catsAppetite;
    }
}
