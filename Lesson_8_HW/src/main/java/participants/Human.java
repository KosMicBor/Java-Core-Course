package participants;

public class Human implements PhysicalActions {
    private final int VAL_ZERO = 0;
    private final int MIN_AGE = 18;
    private final int MAX_AGE = 100;
    private final int MIN_WEIGHT = 45; //в расчёт берутся люди старше 18 лет
    private final int MAX_WEIGHT = 150;

    private String name;
    private int age;
    private int weight; //в киллограммах
    private int maxRunDistance; // это метры
    private float maxJumpHeight; //это тоже метры
    private boolean isObstacleOvercome;

    public Human (String name, int age, int weight, int maxRunDistance, float maxJumpHeight){
        this.name = name;

        if (ageChecker(age)) {
            this.age = age;
        }

        if (weightChecker(weight)) {
            this.weight = weight;
        }

        if(isValueCorrect(maxRunDistance)){
            this.maxRunDistance = maxRunDistance;
        }

        if(isValueCorrect(maxJumpHeight)){
            this.maxJumpHeight = maxJumpHeight;
        }
    }


    @Override
    public void run(int runDistance){
        System.out.printf("Человек по имени %s побежал%n", this.name);

        if (runDistance > this.maxRunDistance){
            System.out.printf("%s не смог пробежать дистанцию%n", this.name);
            isObstacleOvercome = false;
        } else {
            System.out.printf("%s успешно пробежал дистанцию%n", this.name);
            isObstacleOvercome = true;
        }
    }

    @Override
    public void jump(float jumpHeight) {
        System.out.printf("Человек по имени %s прыгнул%n", this.name);

        if (jumpHeight > this.maxJumpHeight) {
            System.out.printf("%s не смог перепрыгнуть стену%n", this.name);
            isObstacleOvercome = false;
        } else {
            System.out.printf("%s успешно перепрыгнул стену%n", this.name);
            isObstacleOvercome = true;
        }
    }

    @Override
    public void info(){
        StringBuilder builder = new StringBuilder();
        builder.append("Имя человека: ");
        builder.append(this.name);
        builder.append("; ");
        builder.append("возраст человека: ");
        builder.append(this.age);
        builder.append("; ");
        builder.append("вес человека: ");
        builder.append(this.weight);
        builder.append(" кг.\n");
        builder.append("Он может пробежать ");
        builder.append(maxRunDistance);
        builder.append(" м и прыгнуть на высоту ");
        builder.append(maxJumpHeight);
        builder.append(" м. \n");

        System.out.println(builder);
    }

    @Override
    public boolean getIsObstacleOvercome() {
        return isObstacleOvercome;
    }

    /**
     * The method checks if age is in range
     * @param age age of Cat current object
     * @return true if age is correct and false if it is not
     */
    private boolean ageChecker(int age){

        if (age >= MIN_AGE && age <= MAX_AGE){
            return true;
        }

        System.out.println("Введён некорректный возраст, который может быть только в диапазоне от 1 до 100 лет");
        return false;
    }

    /**
     * This method checks if weight is in range
     * @param weight weight of Cat current object
     * @return
     */
    private boolean weightChecker(int weight){

        if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT){
            return true;
        }

        System.out.printf("Введён некорректный вес, который может варьироваться только в диапазоне от %d до %d кг%n",
                            MIN_WEIGHT, MAX_WEIGHT);
        return false;
    }

    /**
     * The method checks if some values (distance for example) is correct
     * @param value some int value
     * @return true if value is correct and false if it is not
     */
    private boolean isValueCorrect(float value){

        if (value > VAL_ZERO){
            return true;
        }

        System.out.println("Введено некорректное значение в одном из числовых полей");
        return false;
    }
}
