package ting.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;

public class SemaphoreProducerConsumer {
    private final List<Integer> buffer;
    private final int capacity;
    private final Semaphore empty;  // 空槽位數量
    private final Semaphore full;   // 滿槽位數量
    private final ReentrantLock lock = new ReentrantLock();
    private int producedCount = 0;
    private int consumedCount = 0;
    private int head = 0, tail = 0;

    public SemaphoreProducerConsumer(int capacity) {
        this.capacity = capacity;
        this.buffer = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.add(null);
        }
        this.empty = new Semaphore(capacity);
        this.full = new Semaphore(0);
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
            empty.acquire(); // 等待空槽位

            lock.lock();
            try {
                int item = ++producedCount;
                buffer.set(tail, item);
                tail = (tail + 1) % capacity;
                System.out.println("Producer-" + id + " produced: " + item);
            } finally {
                lock.unlock();
            }

            full.release(); // 釋放滿槽位信號
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
            full.acquire(); // 等待滿槽位

            Integer item;
            lock.lock();
            try {
                item = buffer.get(head);
                buffer.set(head, null);
                head = (head + 1) % capacity;
                consumedCount++;
                System.out.println("Consumer-" + id + " consumed: " + item);
            } finally {
                lock.unlock();
            }

            empty.release(); // 釋放空槽位信號
        }
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(new Producer(1, 6));
        executor.submit(new Producer(2, 4));
        executor.submit(new Consumer(1, 4));
        executor.submit(new Consumer(2, 3));
        executor.submit(new Consumer(3, 3));

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Final - Produced: " + producedCount +
                           ", Consumed: " + consumedCount);
    }
}
