package minicsp.operations;

import java.util.Set;

import minicsp.IntVar;
import minicsp.IntView;

public abstract class BaseIntBiOperation implements IntView {
    private final IntView x;
    private final IntView y;

    public BaseIntBiOperation(final IntView x, final IntView y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void buildVariables(final Set<IntVar> variables) {
        x.buildVariables(variables);
        y.buildVariables(variables);
    }

    @Override
    public boolean isSet() {
        return x.isSet() && y.isSet();
    }

    @Override
    public int getValue() {
        return getValue(x.getValue(), y.getValue());
    }

    public abstract int getValue(int x, int y);
}
