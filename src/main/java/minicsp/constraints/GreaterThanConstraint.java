package minicsp.constraints;

import minicsp.IntView;

public class GreaterThanConstraint extends BaseIntConstraint {

    public GreaterThanConstraint(final IntView x, final IntView y) {
        super(x, y);
    }

    @Override
    public boolean isSatisfied(final int x, final int y) {
        return x > y;
    }
}
