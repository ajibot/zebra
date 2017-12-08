package minicsp;

import java.util.Set;

public class IntVar implements IntView {
    private final int lowerBound;
    private final int upperBound;
    private boolean set;
    private int value;

    public IntVar(final int lowerBound, final int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        value = lowerBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    @Override
    public boolean isSet() {
        return set;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
        set = true;
    }

    public void clearValue() {
        set = false;
    }

    @Override
    public void buildVariables(final Set<IntVar> variables) {
        variables.add(this);
    }

    @Override
    public String toString() {
        return set ? Integer.toString(value) : "x";
    }
}
