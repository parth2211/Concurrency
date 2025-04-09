package addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {

    Value value;
    Lock lockForValue;
    Lock lockForValueString;

    Subtractor(Value value, Lock lockForValue, Lock lockForValueString) {
        this.value = value;
        this.lockForValue = lockForValue;
        this.lockForValueString = lockForValueString;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                Thread.sleep(50L);

            } catch (InterruptedException e) {

            }

            lockForValue.lock();
            int curr = value.getValue();
            int nxt = curr - i;
            value.setValue(nxt);
            lockForValue.unlock();
        }
    }
}
