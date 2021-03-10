package java_core.gu_1089.lesson_12.hw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FillArrayClass extends Thread implements Runnable {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static final int ZERO_VAL = 0;
    private static final int HALVES_QUANTITY = 2;
    private static final int ONE_HALF_READY = 1;

    private volatile int lockReset = 0;
    private final float[] arr = new float[SIZE];
    private final float[] firstHalfArr = new float[HALF];
    private final float[] secondHalfArr = new float[SIZE];


    @Override
    public void run() {
        fullArrayFilling();
        HalfArrayFilling();
    }

    /**
     * This method fills and calculates new array's values in one Thread
     */
    private void fullArrayFilling (){
        final float[] arr = new float[SIZE];
        long startTime = System.currentTimeMillis();
        long endTime = 0l;
        long methodExecutionTime = 0l;

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        endTime = System.currentTimeMillis();
        methodExecutionTime = (endTime - startTime);
        System.out.printf("время выполнения метода в одном потоке: %d мc.%n", methodExecutionTime);
    }

    /**
     * This method fills and calculates new array's values by dividing it to two halves. Also it counts
     * time of method's processes
     */
    private void HalfArrayFilling (){
        long timePoint;

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        timePoint = System.currentTimeMillis();
        System.arraycopy(arr, ZERO_VAL, firstHalfArr, ZERO_VAL, HALF);
        System.arraycopy(arr, HALF, secondHalfArr, HALF, HALF);
        System.out.printf("время разбивки массива: %d мc.%n", System.currentTimeMillis() - timePoint);

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    FillArrayClass.this.HalfArrFilling(arr, firstHalfArr, ZERO_VAL, HALF);
                }
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (lockReset != ONE_HALF_READY){
                            this.wait();
                        }
                    } catch (InterruptedException e){
                        System.out.println("Ups, \"wait\" didn't work");
                    }


                    FillArrayClass.this.HalfArrFilling(arr, secondHalfArr, HALF, SIZE);
                    this.notify();
                }
            }
        });

        service.shutdown();

        synchronized (this) {

            while(lockReset != HALVES_QUANTITY){

                try{
                    this.wait();
                } catch (InterruptedException e){
                    System.out.println("Ups, \"wait\" didn't work");
                }
            }
            timePoint = System.currentTimeMillis();
            System.arraycopy(firstHalfArr, ZERO_VAL, arr, ZERO_VAL, HALF);
            System.arraycopy(secondHalfArr, HALF, arr, HALF, HALF);
            System.out.printf("время склейки массива: %d мc.%n", System.currentTimeMillis() - timePoint);
        }
    }

    /**
     * The method calculates and fills half of some array
     * @param mainArr some float array which used if formula
     * @param halfArr  float array which represents as a half of mainArr
     * @param fromNum index from which the halfArr will fill
     * @param toNum index to which the halfArr will fill
     */
    private synchronized void HalfArrFilling (float[] mainArr, float[] halfArr, int fromNum, int toNum){
        long timePoint = System.currentTimeMillis();
        ++lockReset;

        for (int i = fromNum; i < toNum; i++) {
            halfArr[i] = (float) (mainArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }

        System.out.printf("время выполнения метода: %d мc.%n", System.currentTimeMillis() - timePoint);
    }
}
