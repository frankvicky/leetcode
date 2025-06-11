package ting.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedProducerConsumer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;
    private final Object lock = new Object();
    private int producedCount = 0;
    private int consumedCount = 0;

    public SynchronizedProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    class Producer implements Runnable {
        private final int id;
        private final int itemsToProduce;

        public Producer(int id, int itemsToProduce) {
            this.id = id;
            this.itemsToProduce = itemsToProduce;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < itemsToProduce; i++) {
                    produce();
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void produce() throws InterruptedException {
            synchronized (lock) {
                // 等待直到緩衝區有空間
                while (buffer.size() >= capacity) {
                    System.err.println(Thread.currentThread().getName() + " producer is waiting");
                    lock.wait();
                }

                int item = ++producedCount;
                buffer.offer(item);
                System.out.println("Producer-" + id + " produced: " + item +
                                   " (buffer size: " + buffer.size() + ")");

                // 通知等待的消費者
                lock.notifyAll();
            }
        }
    }

    class Consumer implements Runnable {
        private final int id;
        private final int itemsToConsume;

        public Consumer(int id, int itemsToConsume) {
            this.id = id;
            this.itemsToConsume = itemsToConsume;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < itemsToConsume; i++) {
                    consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void consume() throws InterruptedException {
            synchronized (lock) {
                // 等待直到緩衝區有元素
                while (buffer.isEmpty()) {
                    System.err.println(Thread.currentThread().getName() + " consumer is waiting");
                    lock.wait();
                }

                Integer item = buffer.poll();
                consumedCount++;
                System.out.println("Consumer-" + id + " consumed: " + item +
                                   " (buffer size: " + buffer.size() + ")");

                // 通知等待的生產者
                lock.notifyAll();
            }
        }
    }

    public void start() {
        Thread p1 = new Thread(new Producer(1, 50));
        Thread p2 = new Thread(new Producer(2, 50));
        Thread c1 = new Thread(new Consumer(1, 30));
        Thread c2 = new Thread(new Consumer(2, 30));
        Thread c3 = new Thread(new Consumer(3, 40));

        p1.start(); p2.start();
        c1.start(); c2.start(); c3.start();

        try {
            p1.join(); p2.join();
            c1.join(); c2.join(); c3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final - Produced: " + producedCount +
                           ", Consumed: " + consumedCount);
    }

    public static void main(String[] args) {
        new SynchronizedProducerConsumer(10).start();
    }
}
