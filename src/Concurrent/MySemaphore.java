package Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MySemaphore implements Runnable {
    Semaphore position;
    private int id;

    public MySemaphore(int id, Semaphore position){
        this.id = id;
        this.position = position;
    }

    @Override
    public void run() {
        try {
            if (position.availablePermits() > 0){
                System.out.println("[" + this.id + "] start...");
            }else {
                System.out.println("[" + this.id + "] wait...");
            }
            position.acquire();
            System.out.println("[" + this.id + "] come in...");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println("[" + this.id + "] end...");
            position.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore position = new Semaphore(2);
        for (int i = 0; i < 10; i++){
            service.submit(new MySemaphore(i, position));
        }
        service.shutdown();
        position.acquireUninterruptibly(2);
        System.out.println("over ...");
        position.release(2);

    }
}
