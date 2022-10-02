package org.example.first;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TimePrinter {
    public void printTime() {
        Runnable fivSecondsRunnable = () -> System.out.println("Пройшло 5 секунд");
        var secondsCounter = new Runnable() {
            private static int time = 1;

            @Override
            public void run() {
                System.out.println(time);
                time++;
            }
        };
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(secondsCounter, 1, 1, SECONDS);
        executor.scheduleAtFixedRate(fivSecondsRunnable, 5, 5, SECONDS);
    }
}
