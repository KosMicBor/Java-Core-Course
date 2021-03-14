package java_core.gu_1089.lesson_13.hw;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private final int canBeOnlyOne = 1;

    private ArrayList<Car> finishedCars = new ArrayList<>();
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }
    public ArrayList<Car> getFinishedCars() {
        return finishedCars;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public synchronized void addFinishedCar(Car finishedCar) {
        finishedCars.add(finishedCar);

        if (finishedCars.size() == canBeOnlyOne){
            System.out.println (finishedCar.getName() + " И ЭТО НАШ ПОБЕДИТЕЛЬ!!!");
        } else {
            System.out.println (finishedCar.getName() + " ФИНИШИРОВАЛ!!!");
        }

        if (finishedCars.size() == Car.getCarsCount()){
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}
