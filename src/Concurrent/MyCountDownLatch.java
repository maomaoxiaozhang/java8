package Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(10);
        final ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++){
            final int no = i;
            Runnable runnable = () -> {
                try {
                    System.out.println("begin: " + begin.getCount());
                    begin.await();
                    Thread.sleep((int)(Math.random()*10000));
                    System.out.println("No." + no + " start..." + begin.getCount() + "  " + end.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    end.countDown();
                }
            };
//            final int no = i;
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        begin.await();
//                        Thread.sleep((int)(Math.random()*10000));
//                        System.out.println("No." + no + " arrived...");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }finally {
//                        end.countDown();
//                    }
//                }
//            };
            service.submit(runnable);
        }
        System.out.println("Game start...");
        begin.countDown();
        end.await();
        System.out.println("Game over..." + begin.getCount() + "  " + end.getCount());
        service.shutdown();
    }
}
