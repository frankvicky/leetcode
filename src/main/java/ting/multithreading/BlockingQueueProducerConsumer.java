package ting.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueProducerConsumer {
    private final BlockingQueue<Integer> queue;
    private final AtomicInteger producedCount = new AtomicInteger(0);
    private final AtomicInteger consumedCount = new AtomicInteger(0);

    public BlockingQueueProducerConsumer(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    // Producer 實作
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
                    int item = producedCount.incrementAndGet();
                    queue.put(item); // 阻塞直到有空間
                    System.out.println("Producer-" + id + " produced: " + item);
                    Thread.sleep(100); // 模擬生產時間
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Consumer 實作
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
                    Integer item = queue.take(); // 阻塞直到有元素
                    consumedCount.incrementAndGet();
                    System.out.println("Consumer-" + id + " consumed: " + item);
                    Thread.sleep(150); // 模擬消費時間
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(6);

        // 啟動2個生產者
        executor.submit(new Producer(1, 5));
        executor.submit(new Producer(2, 10));

        // 啟動3個消費者
        executor.submit(new Consumer(1, 6));
        executor.submit(new Consumer(2, 5));
        executor.submit(new Consumer(3, 4));

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("Final - Produced: " + producedCount.get() +
                           ", Consumed: " + consumedCount.get());
    }

    public static void main(String[] args) {
        new BlockingQueueProducerConsumer(3).start();
    }
}
