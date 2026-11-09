import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskProcessor {

    public void processTask(int taskId) {

        System.out.println(
            "Task " + taskId + " started by "
            + Thread.currentThread().getName()
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task interrupted.");
            return;
        }

        System.out.println("Task " + taskId + " completed.");
    }
}

public class ConcurrencyApplication {

    public static void main(String[] args) {

        TaskProcessor processor = new TaskProcessor();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Concurrency Application Started.");

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            executor.execute(() -> processor.processTask(taskId));
        }

        executor.shutdown();

        System.out.println("All tasks submitted.");
    }
}
