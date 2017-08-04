package Concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MyExecutor implements Runnable {
    public int index;
    public MyExecutor(int i){
        this.index = i;
    }

    public void run(){
        try {
            System.out.println("[" + this.index + "] start..." + "  thread name is: " + Thread.currentThread().getName());
            Thread.sleep((int)(Math.random()*10000));
            System.out.println("[" + this.index + "] end..." + "  thread name is: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(1);
        ExecutorService service_2 = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++){
            if (i%2==0)
                service_2.execute(new MyExecutor(i));
            else
                service.execute(new MyExecutor(i));
//            new Thread(new MyExecutor(i)).start();
        }
//        System.out.println("submit finish");
        service.shutdown();
        service_2.shutdown();
    }

}
