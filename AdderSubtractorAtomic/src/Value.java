package src;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
    private int value = 0;
    private AtomicInteger atomicValue = new AtomicInteger(0);
    private String valueString = "";

    public void atomicAdd() {
        atomicValue.incrementAndGet();
    }

    public void atomicSub() {
        atomicValue.decrementAndGet();
    }

    public void addValue(int i) {
        value += i;
    }

    public void subtractValue(int i) {
        value -= i;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public int getValue() {
        return atomicValue.get();
    }

    public void setValue(int i) {
        value = i;
    }


}
