package participants;

public class Robot implements PhysicalActions {
    private final  int VAL_ZERO = 0;
    private final int MIN_WEIGHT = 50; //в киллограммах
    private final int MAX_WEIGHT = 200; //в киллограммах

    private String id;
    private int weight; //в киллограммах
    private int maxRunDistance; // это метры
    private float maxJumpHeight; //это тоже метры
    private boolean isObstacleOvercome;

    public Robot (String name, int weight, int maxRunDistance, float maxJumpHeight){
        this.id = name;

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
        builder.append("ID робота: ");
        builder.append(this.id);
        builder.append("; ");
        builder.append("вес робота: ");
        builder.append(this.weight);
        builder.append(" кг.");

        System.out.println(builder);
    }
    @Override
    public void run(int runDistance){
        System.out.printf("Робот с ID %s побежал%n", this.id);

        if (runDistance > this.maxRunDistance){
            System.out.printf("%s не смог пробежать дистанцию%n", this.id);
            isObstacleOvercome = false;

        } else {
            System.out.printf("%s успешно пробежал дистанцию%n", this.id);
            isObstacleOvercome = true;
        }
    }

    @Override
    public void jump(float jumpHeight) {
        System.out.printf("Робот по имени %s прыгнул%n", this.id);

        if (jumpHeight > this.maxJumpHeight) {
            System.out.printf("%s не смог перепрыгнуть стену%n", this.id);
            isObstacleOvercome = false;
        } else {
            System.out.printf("%s успешно перепрыгнул стену%n", this.id);
            isObstacleOvercome = true;
        }
    }

    @Override
    public boolean getIsObstacleOvercome() {
        return isObstacleOvercome;
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
