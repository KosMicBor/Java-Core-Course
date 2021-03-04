package java_core.gu_1089.lesson_7_hw;

public class Plate {
    private int food;
    private int maxFood;
    private int newFoodQuantity;

    public Plate(int food){
        this.food = food;
        maxFood = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int moreFood) {
        newFoodQuantity = this.food + moreFood;

        if (newFoodQuantity <= maxFood){
            this.food = newFoodQuantity;
            System.out.printf("Еда была успешно добавлена в тарелку, Текущее количество еды в тарелке: %d%n", food);
        } else{
            System.out.println("Вы хотите положить слишком много еды, она вывалится из тарелки");
        }
    }

    public void decreaseFood(int catsAppetite){
        // реализовал защиту от поедания еды до отрицательного значения в тарелке, хотя эта защита была
        // уже реализована в коте - метод checkFood(), вызывается методом eat().
        if (catsAppetite > food) {
            System.out.println("В тарелке недостаточно еды, чтобы накормить кота");
        } else{
            food -= catsAppetite;
        }
    }

    /**
     * The method prints into the console quantity of food on the plate
     * @return String with quantity of food on the plate
     */
    public String printLeftoverFood (){
        return "В тарелке осталось еды: " + food;
    }

}
