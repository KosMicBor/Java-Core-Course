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

    /**
     * The method gets appetite of current Cat's object
     * @return int value
     */
    public int getAppetite() {
        return appetite;
    }

    /**
     * The method feeds current cat
     * @param currentPlate current plate object
     */
    public void eat(Plate currentPlate){
        StringBuilder builder = new StringBuilder();

        if (checkFood(currentPlate)) {
            currentPlate.decreaseFood(appetite);
            satiety = true;

            builder.append(name);
            builder.append(" откушал(а) ");
            builder.append(appetite);

            System.out.println(builder);
        } else {
            satiety = false;
        }
    }

    /**
     * The method checks if there not enough food on the plate
     * @param currentPlate current plate object
     * @return true if food enough, false if not enough
     */
    private boolean checkFood(Plate currentPlate){
        int foodQuantity = currentPlate.getFood();

        if (foodQuantity > 0 && foodQuantity >= appetite){
            return true;
        } else{
            System.out.println("В тарелке недостаточно еды.");
        }

        return false;
    }

    /**
     * method checks if cat full after feeding
     * @return true if cat full, false if it is not
     */
    public String IsCatFull() {

        if(satiety) {
            return name + " наелся и спит";
        }

        return name + " всё ещё голодный";
    }
}
