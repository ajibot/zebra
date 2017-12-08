package minicsp.constraints;

import minicsp.IntView;

public class NotEqualsConstraint extends BaseIntConstraint {

    public NotEqualsConstraint(final IntView x, final IntView y) {
        super(x, y);
    }

    @Override
    public boolean isSatisfied(final int x, final int y) {
        return x != y;
    }
}
