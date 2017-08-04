package Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MyBlockingQueue implements Runnable {
    public static BlockingQueue<String> queue = new LinkedBlockingDeque<>(3);
    private int index;

    public MyBlockingQueue(int index){
        this.index = index;
    }

    @Override
    public void run() {
        try {
            queue.put(String.valueOf(this.index));
            System.out.println("{" + this.index + "} in queue...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++){
            service.submit(new MyBlockingQueue(i));
        }
//        Thread thread = new Thread(){
//            public void run(){
//                try {
//                    while (true){
//                        Thread.sleep((int)(Math.random()*10000));
//                        if (MyBlockingQueue.queue.isEmpty())
//                            break;
//                        String str = MyBlockingQueue.queue.take();
//                        System.out.println(str + " have taken...");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
        Runnable runnable = ()->{try {
            while (true){
                Thread.sleep((int)(Math.random()*1000));
                if (MyBlockingQueue.queue.isEmpty())
                    break;
                String str = MyBlockingQueue.queue.take();
                System.out.println(str + " have taken...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        };
        service.submit(runnable::run);
        service.shutdown();
    }
}
