package org.example.second;

import java.util.function.IntConsumer;

public class FizzBuzzPrinter {

    private final FizzBuzz fizzBuzz;

    public FizzBuzzPrinter(int n) {
        this.fizzBuzz = new FizzBuzz(n);
    }

    public void print() {
        Runnable printFizz = () -> System.out.print("fizz ");
        Runnable printBuzz = () -> System.out.print("buzz ");
        Runnable printFizzBuzz = () -> System.out.print("fizzbuzz ");
        IntConsumer printNumber = x -> System.out.print(x + " ");

        var threadA = getFiizThread(printFizz);
        var threadB = getBuzzThread(printBuzz);
        var threadC = getFizzBuzzThread(printFizzBuzz);
        var threadD = getNumberThread(printNumber);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    private Thread getFiizThread(Runnable printFizz) {
        return new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private Thread getBuzzThread(Runnable printBuzz) {
        return new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private Thread getFizzBuzzThread(Runnable printFizzBuzz) {
        return new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private Thread getNumberThread(IntConsumer printNumber) {
        return new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
