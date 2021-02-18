package java_core.gu_1089.lesson_7_hw;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat (String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate currentPlate){
    StringBuilder builder = new StringBuilder();

        if (checkFood(currentPlate)) {
            currentPlate.decreaseFood(appetite);
            satiety = true;

            builder.append(name);
            builder.append(" откушал(а) ");
            builder.append(appetite);
            builder.append(". Еды осталось ");
            builder.append(currentPlate.getFood());

            System.out.println(builder);
        }
    }

    private boolean checkFood(Plate currentPlate){
        int foodQuantity = currentPlate.getFood();

        if (foodQuantity > 0 && foodQuantity >= appetite){
            return true;
        } else{
            System.out.println("В тарелке недостаточно еды.");
        }

        return false;
    }

    public boolean getSatiety() {
        return satiety;
    }
}
