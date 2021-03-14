package java_core.gu_1089.lesson_13.hw;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private final Race race;
    private final int speed;
    private final String name;
    private static CyclicBarrier barrier;
    private static volatile int carsStarted = 0;
    private volatile int stagesFinished = 0;

    public static int getCarsStarted() {
        return carsStarted;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public void increaseStagesFinished(){
        stagesFinished++;
    }

    public static void setStartBarrier(CyclicBarrier cb){
        barrier = cb;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public static int getCarsCount() {
        return CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            barrier.await();
            System.out.println(this.name + " готов");
            carsStarted++;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // было принято, что обязательно должны стартовать все участники, чтобы гонка началась.
            if(Car.carsStarted == CARS_COUNT){
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        synchronized (this) {
            if (stagesFinished == race.getStages().size()) {
                race.addFinishedCar(this);
            }
        }
    }
}
