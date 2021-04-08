package participants;

public class Cat implements PhysicalActions {
    private final  int VAL_ZERO = 0;
    private final int MAX_AGE = 20; //в годах
    private final int MIN_WEIGHT = 4; //в киллограммах
    private final int MAX_WEIGHT = 12; //в киллограммах

    private String nickname;
    private String color;
    private int age;
    private int weight; //в киллограммах
    private int maxRunDistance; // это метры
    private float maxJumpHeight; //это тоже метры
    private boolean isObstacleOvercome;

    public Cat (String nickname, String color, int age, int weight, int maxRunDistance, float maxJumpHeight){
        this.nickname = nickname;
        this.color = color;

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
    public void info(){
        StringBuilder builder = new StringBuilder();
        builder.append("Кличка кота: ");
        builder.append(this.nickname);
        builder.append("; ");
        builder.append("цвет кота: ");
        builder.append(this.color);
        builder.append("; ");
        builder.append("возраст кота: ");
        builder.append(this.age);
        builder.append("; ");
        builder.append("вес кота: ");
        builder.append(this.weight);
        builder.append(" кг.");

        System.out.println(builder);
    }

    @Override
    public void run(int runDistance){
        System.out.printf("Кот по кличке %s побежал%n", this.nickname);

        if (runDistance > this.maxRunDistance){
            System.out.printf("%s не смог пробежать дистанцию%n", this.nickname);
            isObstacleOvercome = false;
        } else {
            System.out.printf("%s успешно пробежал дистанцию%n", this.nickname);
            isObstacleOvercome = true;
        }
    }

    @Override
    public void jump(float jumpHeight) {
        System.out.printf("Кот по кличке %s прыгнул%n", this.nickname);
        if (jumpHeight > this.maxJumpHeight) {
            System.out.printf("%s не смог перепрыгнуть стену%n", this.nickname);
            isObstacleOvercome = false;
        }
        System.out.printf("%s успешно перепрыгнул стену%n", this.nickname);
        isObstacleOvercome = true;
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

        if (age > VAL_ZERO && age <= MAX_AGE){
            return true;
        }

        System.out.println("Введён некорректный возраст, который может быть только в диапазоне от 1 до 20 лет");
        return false;

    }

    /**
     * This method checks if weight is in range
     * @param weight weight of Cat current object
     * @return
     */
    private boolean weightChecker(int weight){

        if (weight > MIN_WEIGHT && weight <= MAX_WEIGHT){
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
