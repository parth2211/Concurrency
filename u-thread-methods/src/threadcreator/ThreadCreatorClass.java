package threadcreator;

import java.util.concurrent.TimeUnit;

public class ThreadCreatorClass extends Thread{

    @Override
    public void run() {
        Thread currThread = Thread.currentThread();
        System.out.println(currThread.getName() + "-" + currThread.threadId());

        for(int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currThread.getName() + "-" + currThread.threadId() + " prints : " + i);
        }
    }
}
