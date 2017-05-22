import java.util.Random;

public class EatLoop implements Runnable {
    private Philosopher philosopher;
    private boolean isRunning = true;

    EatLoop(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    public void run() {
        Random random = new Random();
        while (isRunning) {
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!philosopher.eat()) {
                isRunning = false;
            }
        }
    }
}