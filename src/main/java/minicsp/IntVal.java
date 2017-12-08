package minicsp;

import java.util.Set;

public class IntVal implements IntView {
    private final int value;

    public IntVal(final int value) {
        this.value = value;
    }

    @Override
    public boolean isSet() {
        return true;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void buildVariables(final Set<IntVar> variables) {
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
