package GU_Android_1089.lesson_6.homework;

public class Dog extends Animal{
    private final int MAX_RUN_DISTANCE = 500; // это метры
    private final int MAX_SWIM_DISTANCE = 10; // это метры

    private static int dogsQuantity = 0;

    public Dog(String name, String color) {
        super(name, color);
        dogsQuantity++;
    }

    /**
     * This method checks if outer distance is in range and print the result message
     * @param distance distance which dog should swim
     */
    @Override
    public void run(int distance) {
        StringBuilder dogSwimStringBuilder = new StringBuilder();
        dogSwimStringBuilder.append(color);
        dogSwimStringBuilder.append(" ");
        dogSwimStringBuilder.append(name);

        if (distance <= MAX_RUN_DISTANCE && distance > ZERO){
            dogSwimStringBuilder.append(" пробежал(а) ");
            dogSwimStringBuilder.append(distance);
            dogSwimStringBuilder.append("м");
        } else if (distance == ZERO){
            dogSwimStringBuilder.append(" остался(ась) на месте");
        } else if (distance < ZERO){
            dogSwimStringBuilder.append(" превратился(лась) в чёрную дыру! Введи положительное значение!");
        } else {
            dogSwimStringBuilder.append(" столько не пробежит!");
        }

        System.out.println(dogSwimStringBuilder);
    }

    /**
     * This method checks if outer distance is in range and print the result message
     * @param distance distance which dog should swim
     */
    @Override
    public void swim(int distance) {
        StringBuilder DogSwimStringBuilder = new StringBuilder();
        DogSwimStringBuilder.append(color);
        DogSwimStringBuilder.append(" ");
        DogSwimStringBuilder.append(name);

        if (distance <= MAX_SWIM_DISTANCE && distance > ZERO){
            DogSwimStringBuilder.append(" проплыл(а) ");
            DogSwimStringBuilder.append(distance);
            DogSwimStringBuilder.append("м");
        } else if (distance == ZERO){
            DogSwimStringBuilder.append(" остался(ась) на месте");
        } else if (distance < ZERO){
            DogSwimStringBuilder.append(" превратился(лась) в чёрную дыру! Введи положительное значение!");
        } else {
            DogSwimStringBuilder.append(" столько не проплывёт!");
        }

        System.out.println(DogSwimStringBuilder);
    }

    /**
     * This method prints quantity of dogs into the console
     */
    public void getDogsQuantity(){
        System.out.println("Количество собак равно: " + dogsQuantity);
    }
}
