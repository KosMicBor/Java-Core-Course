package java_core.gu_1089_lesson_11_hw.fruit;

public class Apple extends Fruit{
    private float weight;
    private int id;

    public Apple(int id) {
        this.id = id;
        this.weight = 1.0f;

    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Apple apple = (Apple) obj;
        return id == apple.id;
    }

    @Override
    public String toString() {
        return "Apple{" + "id=" + id + ", weight=" + weight +'}';
    }
}
