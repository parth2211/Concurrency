package addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    Value value;
    Lock lockForValue;
    Lock lockForValueString;

    Adder(Value value, Lock lockForValue, Lock lockForValueString) {
        this.value = value;
        this.lockForValue = lockForValue;
        this.lockForValueString = lockForValueString;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try{
                Thread.sleep(50L);
            } catch(Exception e) {
                System.out.println("Exception");
            }

            lockForValue.lock();
            int curr = value.getValue();
            int nxt = curr + i;
            value.setValue(nxt);
            lockForValue.unlock();
        }
    }
}
