package src.printoddeven;

public class HelloPrint implements Runnable {
    int number;

    public HelloPrint(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number " + number + " printed by thread " + Thread.currentThread().getName());
    }
}
