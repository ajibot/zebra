package minicsp.operations;

import minicsp.IntView;

public class AbsOperation extends BaseIntOperation {

    public AbsOperation(final IntView arg) {
        super(arg);
    }

    @Override
    public int getValue(final int arg) {
        return Math.abs(arg);
    }
}
