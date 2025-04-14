import addersubtractorlock.Value;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    Value value;

    Adder(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try{
                Thread.sleep(50L);
            } catch(Exception e) {
                System.out.println("Exception");
            }

//            value.addValue(1); //Though it looks like Atomic (it directly updates value by +1), but it is not atomic
//
//            int curr = value.getValue();
//            int nxt = curr + 1;
//            value.setValue(nxt);
        }
    }
}
