import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DinnerForFive {

    private static Fork[] createFiveForks() {
        return new Fork[]{new Fork(1), new Fork(2), new Fork(3),
                new Fork(4), new Fork(5)};
    }

    public static void main(String[] args) {
        Fork[] fiveForks = createFiveForks();
        final Philosopher descartes = new Philosopher("Descartes", fiveForks[1], fiveForks[0],
                ": I am eating therefor I exist.");
        final Philosopher kant = new Philosopher("Kant", fiveForks[2], fiveForks[1],
                ": Two things awe me most, the starry sky above me and a big steake within me.");
        final Philosopher democritus = new Philosopher("Democritus", fiveForks[3], fiveForks[2],
                ": It is greed to do all the eating but not to want to wait at all.");
        final Philosopher sartre = new Philosopher("Sartre", fiveForks[4], fiveForks[3],
                ": Hell is other eaters.");
        final Philosopher plato = new Philosopher("Plato", fiveForks[0], fiveForks[4],
                ": We are twice armed if we fight with full stomach.");

        new Thread(new EatLoop(descartes)).start();
        new Thread(new EatLoop(kant)).start();
        new Thread(new EatLoop(democritus)).start();
        new Thread(new EatLoop(sartre)).start();
        new Thread(new EatLoop(plato)).start();

    }

    static class Philosopher {
        private final String name;
        private final Fork leftFork;
        private final Fork rightFork;
        private final Lock forksLock = new ReentrantLock();
        private String message;

        Philosopher(String name, Fork leftFork, Fork rightFork, String message) {
            this.name = name;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
            this.message = message;
        }

        String getName() {
            return this.name;
        }

        void takeForks() {
            forksLock.tryLock();
        }

        void putForks() {
            forksLock.unlock();
        }

        void eat() {
            takeForks();
            System.out.println(this.getName() + message);
            putForks();
        }
    }

    static class Fork {
        private final int forkNumber;

        Fork(int forkNumber) {
            this.forkNumber = forkNumber;
        }

        int getForkNumber() {
            return this.forkNumber;
        }
    }

    static class EatLoop implements Runnable {
        private Philosopher philosopher;
        private boolean isRunning = true;

        EatLoop(Philosopher philosopher) {
            this.philosopher = philosopher;
        }

        public void run() {
            Random random = new Random();
            while (isRunning){
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                philosopher.eat();
            }
        }
    }
}
