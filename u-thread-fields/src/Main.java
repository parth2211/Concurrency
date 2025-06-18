public class Main {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        System.out.println("Thread details for understanding ....");
        System.out.println("Thread Name    : " + mainThread.getName());
        System.out.println("ThreadId       : " + mainThread.threadId());
        System.out.println("Thread Priority: " + mainThread.getPriority());
        System.out.println("Thread Group   : " + mainThread.getThreadGroup());
        System.out.println("Thread isAlice : " + mainThread.isAlive());
        System.out.println("Thread State   : " + mainThread.getState());
        System.out.println("Thread Classldr: " + mainThread.getContextClassLoader());

        System.out.println("Thread info : " + mainThread.toString());

        mainThread.setName("My class");
        mainThread.setPriority(8);

        System.out.println("Thread info : " + mainThread.toString());
    }
}