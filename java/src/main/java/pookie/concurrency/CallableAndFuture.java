package pookie.concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {

    // Runnable: run a thread
    // Callable: run/call thread that return a result
    // Future: get return result from Thread
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Random random = new Random();

        final int duration = random.nextInt(4000);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("Starting..");

                Thread.sleep(duration);

                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}
