import java.util.Locale;
import java.util.ResourceBundle;

class Philosopher {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private final long maxTimeWithoutFood;

    private long timeCanWait;
    private long timePoint = 0;

    private String speech;
    private Locale currentLocale = Locale.getDefault();
    private ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

    Philosopher(String name, Fork leftFork, Fork rightFork, String speech, long maxTimeWithoutFood) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.speech = speech;
        this.maxTimeWithoutFood = maxTimeWithoutFood;
    }

    private String getName() {
        return this.name;
    }

    private void countTimeCanWait() {
        if (timePoint == 0) {
            timeCanWait = maxTimeWithoutFood;
            timePoint = System.currentTimeMillis();
        } else {
            long currentTime = System.currentTimeMillis();
            timeCanWait = timeCanWait - (currentTime - timePoint);
            timePoint = currentTime;
        }

        if (this.timeCanWait > 0) {
            System.out.println(getName() + messages.getString("messageCanWait") + timeCanWait);
        } else {
            System.out.println(getName() + messages.getString("messageCannotWait"));
        }
    }


    private boolean isDead() {
        countTimeCanWait();

        if (timeCanWait <= 0) {
            System.out.println(getName() + messages.getString("messageDead"));
            return true;
        } else {
            return false;
        }
    }

    private boolean canTakeForks() {
        if (leftFork.takeFork()) {
            if (rightFork.takeFork()) {
                return true;
            } else {
                leftFork.putFork();
                return false;
            }
        } else {
            return false;
        }
    }

    boolean eat() {
        if (canTakeForks()) {
            System.out.println(getName() + speech);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftFork.putFork();
            rightFork.putFork();
            timeCanWait = maxTimeWithoutFood;
            return true;
        } else {
            System.out.println(getName() + messages.getString("messageCannotTakeTwoForks"));
            return !isDead();
        }
    }
}