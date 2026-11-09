class SharedData {

    private boolean available = false;

    public synchronized void produce() {

        System.out.println("Producer is waiting...");

        available = true;

        System.out.println("Producer has produced data.");

        notify();
    }

    public synchronized void consume() {

        while (!available) {
            try {
                System.out.println("Consumer is waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Consumer has consumed data.");
    }
}

public class InterThreadCommunicationDemo {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        Thread consumer = new Thread(() -> data.consume());

        Thread producer = new Thread(() -> data.produce());

        consumer.start();
        producer.start();
    }
}
