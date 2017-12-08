package minicsp.constraints;

import minicsp.IntView;

public class EqualsConstraint extends BaseIntConstraint {

    public EqualsConstraint(final IntView x, final IntView y) {
        super(x, y);
    }

    @Override
    public boolean isSatisfied(final int x, final int y) {
        return x == y;
    }
}
