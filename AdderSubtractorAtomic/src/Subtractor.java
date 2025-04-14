import addersubtractorlock.Value;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {

    Value value;

    Subtractor(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                Thread.sleep(50L);

            } catch (InterruptedException e) {
                System.out.println("Exception");
            }

            int curr = value.getValue();
            int nxt = curr - 1;
            value.setValue(nxt);
        }
    }
}
