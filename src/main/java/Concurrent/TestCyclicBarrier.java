package Concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by zhanggq on 2017/8/14.
 */
public class TestCyclicBarrier {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(4);
        final Random random = new Random();

//        final CyclicBarrier barrier = new CyclicBarrier(4, () -> {
//            System.out.println("together~");
//        });
        final CountDownLatch latch = new CountDownLatch(4);

        Runnable person = () -> {

        };

        class people implements Runnable{

            @Override
            public void run() {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " arrive ");
//                try {
//                    barrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
                latch.countDown();
                latch.countDown();
            }
        }

        people[] peoples = new people[4];
        for (int i = 0; i < 4; i++){
            peoples[i] = new people();
        }

        for (int i = 0; i < 4; i++){
            pool.execute(peoples[i]);
        }
        pool.shutdown();
    }
}
