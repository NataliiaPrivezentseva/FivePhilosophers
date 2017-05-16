class Philosopher {
    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;

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

    void eat() {
        if (this.canTakeForks()) {
            System.out.println(this.getName() + message);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftFork.putFork();
            rightFork.putFork();
        } else {
            System.out.println(this.getName() + ": I cannot take two forks! I must wait!");
        }
    }
}

