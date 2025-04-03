package src.addersubtractor;

public class Adder implements Runnable {

    Value value;

    Adder(Value value) {
        this.value = value;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try{
                Thread.sleep(5L);
                value.setValue(value.getValue() + 1);
            } catch(Exception e) {
                System.out.println("Exception");
            }
        }
    }
}
