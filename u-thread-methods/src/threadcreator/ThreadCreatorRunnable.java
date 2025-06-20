package threadcreator;

import java.util.concurrent.TimeUnit;

public class ThreadCreatorRunnable implements Runnable{
    @Override
    public void run() {
        Thread currThread = Thread.currentThread();
        System.out.println(currThread.getName() + "-" + currThread.threadId());

        for(int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                if(i == 3) {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currThread.getName() + "-" + currThread.threadId() + " prints : " + (i+1));
        }
    }
}
