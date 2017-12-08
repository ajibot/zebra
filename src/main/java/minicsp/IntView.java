package minicsp;

import java.util.Set;

import minicsp.constraints.EqualsConstraint;
import minicsp.constraints.GreaterThanConstraint;
import minicsp.constraints.NotEqualsConstraint;
import minicsp.operations.AbsOperation;
import minicsp.operations.SubtractOperation;

public interface IntView {

    void buildVariables(Set<IntVar> variables);

    boolean isSet();

    int getValue();

    default AbsOperation abs() {
        return new AbsOperation(this);
    }

    default EqualsConstraint eq(final IntView other) {
        return new EqualsConstraint(this, other);
    }

    default EqualsConstraint eq(final int other) {
        return new EqualsConstraint(this, new IntVal(other));
    }

    default GreaterThanConstraint gt(final IntView other) {
        return new GreaterThanConstraint(this, other);
    }

    default NotEqualsConstraint ne(final IntView other) {
        return new NotEqualsConstraint(this, other);
    }

    default SubtractOperation sub(final IntView other) {
        return new SubtractOperation(this, other);
    }
}
