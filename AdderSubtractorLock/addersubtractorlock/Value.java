package addersubtractorlock;

public class Value {
    private int value = 0;
    private String valueString = "";

    public void addValue(int i) {
        value += i;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public void subtractValue(int i) {
        value -= i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int i) {
        value = i;
    }
}
