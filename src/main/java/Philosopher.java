class Philosopher {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private final long maxTimeWithoutFood;

    private long timeCanWait;
    private long timePoint = 0;

    private String message;

    Philosopher(String name, Fork leftFork, Fork rightFork, String message, long maxTimeWithoutFood) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.message = message;
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
            System.out.println(getName() + ": I can wait " + timeCanWait);
        } else {
            System.out.println(getName() + ": But I can't wait anymore... I am starving.");
        }
    }


    private boolean isDead() {
        countTimeCanWait();

        if (timeCanWait <= 0) {
            System.out.println(getName() + ": DEAD!!!");
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
            System.out.println(getName() + message);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftFork.putFork();
            rightFork.putFork();
            return true;
        } else {
            System.out.println(getName() + ": I cannot take two forks! I must wait!");
            return !isDead();
        }
    }
}