package Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MyReentrantLock implements Runnable {
    private int id;
    TestReentrantLock lock;

    public MyReentrantLock(int id, TestReentrantLock lock){
        this.id = id;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.print(id);
    }

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        TestReentrantLock lock = new TestReentrantLock();
        for (int i = 0; i < 10; i++){
            service.submit(new MyReentrantLock(i, lock));
        }
        service.shutdown();
    }
}

class TestReentrantLock{
    private ReentrantLock lock = new ReentrantLock();

    public void print(int str){
        try {
            lock.lock();
            System.out.println(str + " achieve...");
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(str + " release...");
            lock.unlock();
        }
    }
}

