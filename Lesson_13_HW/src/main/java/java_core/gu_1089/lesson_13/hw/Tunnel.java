package java_core.gu_1089.lesson_13.hw;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{
    private final int MAX_CARS_IN_TUNNEL = 2;
    private final Semaphore cd = new Semaphore(MAX_CARS_IN_TUNNEL);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                cd.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                c.increaseStagesFinished();
                cd.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
