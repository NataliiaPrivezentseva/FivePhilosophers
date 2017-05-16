class Philosopher {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private final long maxTimeWithoutFood;

    private long timeCanWait;
    private long waitingTime = 0;
    private long currentTime;

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

    private void countTimeCanWait(){
        if (waitingTime == 0) {
            this.timeCanWait = maxTimeWithoutFood;
            this.currentTime = System.currentTimeMillis();
        } else {
            long currentTime = System.currentTimeMillis();
            this.waitingTime = currentTime - this.currentTime;
            this.timeCanWait = maxTimeWithoutFood - waitingTime;
        }
        this.timeCanWait = this.timeCanWait - waitingTime;
    }


    private boolean isDead() {
        this.countTimeCanWait();

        if (this.timeCanWait <= 0) {
            System.out.println(this.getName() + ": DEAD!!!");
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
        if (this.canTakeForks()) {
            System.out.println(this.getName() + message);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftFork.putFork();
            rightFork.putFork();
            return true;
        } else {
            System.out.println(this.getName() + ": I cannot take two forks! I must wait!");
            return !this.isDead();
        }
    }
}

