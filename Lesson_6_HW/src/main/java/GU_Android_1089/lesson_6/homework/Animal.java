package GU_Android_1089.lesson_6.homework;

abstract class  Animal {
    final int ZERO = 0;

    private static int animalCount = 0;

    String name;
    String color;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
        animalCount++;
    }

    abstract void run(int distance);

    abstract void swim(int distance);

    public void getAnimalsQuantity(){
        System.out.println("Общее количество животных равно: " + animalCount);
    }
}
