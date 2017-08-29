package Concurrent;

import java.util.concurrent.*;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MyCompletionService implements Callable<String> {
    private int id;

    public MyCompletionService(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Integer time = (int)(Math.random()*10000);
        try {
            System.out.println(this.id + " start...");
            Thread.sleep(time);
            System.out.println(this.id + " end...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return this.id + ":" + time;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<String> completion = new ExecutorCompletionService<>(service);
        for (int i = 0; i< 10; i++){
            completion.submit(new MyCompletionService(i));
        }
        for (int i = 0; i < 10; i++){
            System.out.println(completion.take().get());
        }
        service.shutdown();
    }
}
