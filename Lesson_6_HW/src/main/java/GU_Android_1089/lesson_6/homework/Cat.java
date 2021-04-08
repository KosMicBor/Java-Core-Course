package GU_Android_1089.lesson_6.homework;

class Cat extends Animal{
    private static int catsQuantity = 0;

    private int MAX_RUN_DISTANCE = 200; // это метры

    public Cat(String name, String color) {
        super(name, color);
        catsQuantity++;
    }

    /**
     * This method checks if outer distance is in range and print the result message
     * @param distance distance which cat should swim
     */
    @Override
    public void run(int distance) {
        StringBuilder catRunStringBuilder = new StringBuilder();
        catRunStringBuilder.append(color);
        catRunStringBuilder.append(" ");
        catRunStringBuilder.append(name);

        if (distance <= MAX_RUN_DISTANCE && distance > ZERO){
            catRunStringBuilder.append(" пробежал(а) ");
            catRunStringBuilder.append(distance);
            catRunStringBuilder.append("м");
        } else if (distance == ZERO){
            catRunStringBuilder.append(" остался(ась) на месте");
        } else if (distance < ZERO){
            catRunStringBuilder.append(" превратился(лась) в чёрную дыру! Введи положительное значение!");
        } else {
            catRunStringBuilder.append(" столько не пробежит!");
        }

        System.out.println(catRunStringBuilder);
    }

    /**
     * This method prints that cats can't swim
     * @param distance distance which dog should swim but it is not necessary here
     */
    @Override
    public void swim(int distance) {
        StringBuilder catSwimStringBuilder = new StringBuilder();
        catSwimStringBuilder.append("Котэ шикарен, но плавать не умеет!");
        System.out.println(catSwimStringBuilder);
    }

    /**
     * This method prints quantity of cats into the console
     */
    public void getCatsQuantity(){
        System.out.println("Количество котов равно: " + catsQuantity);
    }
}
