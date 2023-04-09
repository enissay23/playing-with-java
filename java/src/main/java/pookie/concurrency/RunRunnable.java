package pookie.concurrency;

public class RunRunnable {

    // Runnable: run a thread without returning a value or an object
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("starting..");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");
            }
        });

        t1.start();
    }
}
