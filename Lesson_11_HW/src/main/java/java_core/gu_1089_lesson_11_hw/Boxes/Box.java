package java_core.gu_1089_lesson_11_hw.Boxes;

import java_core.gu_1089_lesson_11_hw.fruit.Fruit;

import java.util.ArrayList;


public class Box <T extends Fruit> implements Comparable{
    private static final int ZERO_VAL = 0;
    private int boxID;

    ArrayList<T> box = new ArrayList<T>();
    private float boxWeight;

    public Box(int boxID, ArrayList<T> box) {
        this.boxID = boxID;
        this.box = box;
    }

    /**
     * The method adds some Fruit to the box
     * @param o some Fruit (object T)
     */
    public void add(Object o) {

        if (box.contains(o)) {
            box.add((T) o);
        } else if (box.isEmpty()){
            box.add((T) o);
        } else {
            System.out.println("Невозможно добавить этот объект в текущую коробку");
        }
    }

    /**
     * This method calculates weight of the current box
     * @return float weight of the box
     */
    public float calcWeight(){
        boxWeight = ZERO_VAL;

        for (T elem: box) {
            boxWeight += elem.getWeight();
        }

        return boxWeight;
    }

    /**
     * This method compares weights of two boxes
     * @param someBox box object for comparing
     * @return 0 if boxes are equals, 1 if outer box is heavier than current box and -1 if current box is heavier
     */
    @Override
    public int compareTo(Object someBox) {

        if(((Box) someBox).calcWeight() == this.boxWeight){
            System.out.println("Масса этих коробок равна");
            return 0;
        } else if(((Box) someBox).calcWeight() > this.boxWeight){
            System.out.println("Масса второй коробки больше");
            return 1;
        } else {
            System.out.println("Масса первой коробки больше");
            return -1;
        }
    }

    /**
     * This method prints any box weight into the console
     */
    public void printWeight(){
        float thisBoxWeight = calcWeight();
        String formattedWeight = String.format("Масса этой коробки: %.2f%n", thisBoxWeight);
        System.out.printf(formattedWeight);
    }

    /**
     * This method pours fruit from one box to another
     * @param anotherBox some Box object
     */
    public void pourMethod(Box anotherBox){

        if (this.box != null && anotherBox != null && !box.isEmpty() && !this.equals(anotherBox)) {
            for (T elem : box) {
                anotherBox.add(elem);
            }

        box.clear();
        } else if (box.isEmpty() && box != null){
            System.out.println("Первая коробка пуста, нечего перекладывать");
        } else if (this.equals(anotherBox)){
            System.out.println("Нельзя пересыпать коробку саму в себя!");
        } else {
            System.out.println("Коробки не существует");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T elem: box) {
            builder.append(elem);
            builder.append(" ");
        }

        return String.valueOf(builder);
    }
}
