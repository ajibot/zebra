package minicsp.operations;

import minicsp.IntView;

public class SubtractOperation extends BaseIntBiOperation {

    public SubtractOperation(final IntView x, final IntView y) {
        super(x, y);
    }

    @Override
    public int getValue(final int x, final int y) {
        return x - y;
    }
}
