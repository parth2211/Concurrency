package src.addersubtractor;

public class Subtractor implements Runnable {

    Value value;

    Subtractor(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                Thread.sleep(5L);
                value.value -= 1;
            } catch (InterruptedException e) {

            }
        }
    }
}
