package java_core.gu_1089.lesson_13.hw;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Championship{
    public static final int CARS_COUNT = 4;

    public static final CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        Car.setStartBarrier(cb);

        ExecutorService service = Executors.newFixedThreadPool(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            service.execute(cars[i]);
        }

        service.shutdown();
    }
}
