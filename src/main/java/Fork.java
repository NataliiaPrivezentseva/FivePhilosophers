import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {
    private final Lock forkLock = new ReentrantLock();

    boolean takeFork() {
        return forkLock.tryLock();
    }

    void putFork() {
        forkLock.unlock();
    }
}
