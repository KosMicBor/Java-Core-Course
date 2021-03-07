package java_core.gu_1089_lesson_11_hw.fruit;

public class Orange extends Fruit{
    private float weight;
    private int id;

    public Orange(int id) {
        this.id = id;
        this.weight = 1.5f;
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
        Orange orange = (Orange) obj;
        return id == orange.id;
    }

    @Override
    public String toString() {
        return "Orange{" + "id=" + id + ", weight=" + weight +'}';
    }
}
