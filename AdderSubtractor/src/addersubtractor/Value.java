package src.addersubtractor;

public class Value {
    private int value = 0;

    /**
     * This will also not solve race condition, since thread will first get, then increase by 1, then set
     *  value. So other thread can get the same value and update it in between. Here locks will help
     *
     *  BUT, if we make this 3 step operation atomic by using synchronised add() and subtract() function
     *  then race condition will be solved
     */
    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
