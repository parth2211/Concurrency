package threadcreator;

import java.util.concurrent.TimeUnit;

public class ThreadCreatorRunnable implements Runnable{
    @Override
    public void run() {
        Thread currThread = Thread.currentThread();
        System.out.println(currThread.getName() + "-" + currThread.threadId());

        /**
         * interrupt() function will only set the thread's interrupt flag to true;
         * When thread runs any blocking statement, it first checks if thread's interrupt flag is true or not
         */
        for(int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                if(i == 3) {
                    currThread.interrupt();
                }
                if(currThread.isInterrupted()) {
                    throw new InterruptedException();
                }
                System.out.println(currThread.getName() + "-" + currThread.threadId() + " prints : " + i);
            } catch (InterruptedException e) {
                System.out.println(currThread.getName() + "-" + currThread.threadId() + " got interrupted");
            }
        }
    }
}
