public class LambdaThreadDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Lambda Thread: " + i);
            }
        });

        t1.start();

        System.out.println("Main thread is running.");
    }
}
