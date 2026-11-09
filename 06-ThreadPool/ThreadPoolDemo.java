import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {

            int taskNumber = i;

            executor.execute(() -> {
                System.out.println(
                    "Task " + taskNumber + " is executed by "
                    + Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();

        System.out.println("All tasks submitted successfully.");
    }
}
