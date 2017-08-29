package Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhanggq on 2017/8/10.
 */
public class TestCountLatch {
    private static final int N = 10;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch doneSignal = new CountDownLatch(N);
        CountDownLatch startSignal = new CountDownLatch(1);
        for (int i = 1; i <= N; i++){
//            new Thread(new Worker(i, startSignal, doneSignal)).start();
            pool.execute(new Worker(i, startSignal, doneSignal));
        }
        System.out.println("begin-----");
        startSignal.countDown();
        doneSignal.await();
        pool.shutdown();
        System.out.println("over-----");
    }

    static class Worker implements Runnable{
        private final CountDownLatch doneSignal;
        private final CountDownLatch startSignal;
        private int beginIndex;

        Worker(int beginIndex, CountDownLatch startSiignal, CountDownLatch doneSignal){
            this.beginIndex = beginIndex;
            this.startSignal = startSiignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                System.out.println(Thread.currentThread().getName());
//                beginIndex = (beginIndex - 1) * 10 + 1;
//                for (int i = beginIndex; i <= beginIndex+10; i++){
//                    System.out.println(i);
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                doneSignal.countDown();
                doneSignal.countDown();
            }
        }
    }
}
