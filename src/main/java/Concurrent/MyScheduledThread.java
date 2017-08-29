package Concurrent;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by zhanggq on 2017/8/4.
 */
public class MyScheduledThread {
    public static void main(String[] args){
        final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);
        final Runnable beeper = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                System.out.println(new Date() + " beep " + (++count));
            }
        };
        final ScheduledFuture beeperHandle = schedule.scheduleAtFixedRate(beeper, 1, 2, SECONDS);
        final ScheduledFuture beeperHandle_2 = schedule.scheduleWithFixedDelay(beeper, 2, 5, SECONDS);
        schedule.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
                beeperHandle_2.cancel(true);
                schedule.shutdown();
            }
        }, 30, SECONDS);
    }
}
