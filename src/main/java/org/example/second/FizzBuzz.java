package org.example.second;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private final int n;
    private final AtomicInteger counter;


    public FizzBuzz(int n) {
        this.n = n;
        this.counter = new AtomicInteger(1);
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        int step = n / 3 - n / 15;
        for (int i = 0; i < step; ) {
            synchronized (this) {
                if (counter.get() % 3 == 0 && counter.get() % 15 != 0) {
                    printFizz.run();
                    counter.incrementAndGet();
                    i++;
                }
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        int step = n / 5 - n / 15;
        for (int i = 0; i < step; ) {
            synchronized (this) {
                if (counter.get() % 5 == 0 && counter.get() % 15 != 0) {
                    printBuzz.run();
                    counter.incrementAndGet();
                    i++;
                }
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int step = n / 15;
        for (int i = 0; i < step; ) {
            synchronized (this) {
                if (counter.get() % 15 == 0) {
                    printFizzBuzz.run();
                    counter.incrementAndGet();
                    i++;
                }
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        int step = n - n / 3 - n / 5 + n / 15;
        for (int i = 0; i < step; ){
            synchronized (this) {
                if (counter.get() % 3 != 0 && counter.get() % 5 != 0) {
                    printNumber.accept(counter.get());
                    counter.incrementAndGet();
                    i++;
                }
            }
        }
    }
}