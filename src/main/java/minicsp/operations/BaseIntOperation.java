package minicsp.operations;

import java.util.Set;

import minicsp.IntVar;
import minicsp.IntView;

public abstract class BaseIntOperation implements IntView {
    private final IntView arg;

    public BaseIntOperation(final IntView arg) {
        this.arg = arg;
    }

    @Override
    public void buildVariables(final Set<IntVar> variables) {
        arg.buildVariables(variables);
    }

    @Override
    public boolean isSet() {
        return arg.isSet();
    }

    @Override
    public int getValue() {
        return getValue(arg.getValue());
    }

    public abstract int getValue(int arg);
}
