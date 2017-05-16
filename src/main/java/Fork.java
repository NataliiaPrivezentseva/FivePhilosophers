import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {
    private final int forkNumber;
    private final Lock forkLock = new ReentrantLock();

    Fork(int forkNumber) {
        this.forkNumber = forkNumber;
    }

    boolean takeFork() {
        return forkLock.tryLock();
    }

    void putFork() {
        forkLock.unlock();
    }

    int getForkNumber() {
        return this.forkNumber;
    }
}
