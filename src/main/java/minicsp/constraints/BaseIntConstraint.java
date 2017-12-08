package minicsp.constraints;

import java.util.Set;

import minicsp.Constraint;
import minicsp.IntVar;
import minicsp.IntView;
import minicsp.Result;

public abstract class BaseIntConstraint implements Constraint {
    private final IntView x;
    private final IntView y;

    public BaseIntConstraint(final IntView x, final IntView y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void buildVariables(final Set<IntVar> variables) {
        x.buildVariables(variables);
        y.buildVariables(variables);
    }

    @Override
    public Result isSatisfied() {
        if (!x.isSet() || !y.isSet()) {
            return Result.UNKNOWN;
        }
        return isSatisfied(x.getValue(), y.getValue()) ? Result.YES : Result.NO;
    }

    public abstract boolean isSatisfied(int x, int y);
}
