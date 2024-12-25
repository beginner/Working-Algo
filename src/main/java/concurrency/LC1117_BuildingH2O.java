package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class LC1117_BuildingH2O {

    public LC1117_BuildingH2O() {

    }

    Runnable releaseHydrogen = () -> System.out.println("H");
    Runnable releaseOxygen = () -> System.out.println("O");

    Semaphore hydrogen = new Semaphore(2);
    Semaphore oxygen = new Semaphore(1);
    CyclicBarrier barrier = new CyclicBarrier(3);



    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hydrogen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        oxygen.release();

    }

}
