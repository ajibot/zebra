package minicsp;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Constraint> constraints = new ArrayList<>();

    public IntVar[] intVarArray(final int n, final int lowerBound, final int upperBound) {
        final IntVar[] result = new IntVar[n];
        for (int i = 0; i < n; i++) {
            result[i] = new IntVar(lowerBound, upperBound);
        }
        return result;
    }

    public void allDifferent(final IntVar[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                add(a[i].ne(a[j]));
            }
        }
    }

    public void add(final Constraint constraint) {
        constraints.add(constraint);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    @SuppressWarnings("incomplete-switch")
    public Result isSatisfied() {
        Result result = Result.YES;

        for (final Constraint constraint : constraints) {
            switch (constraint.isSatisfied()) {
            case NO:
                return Result.NO;
            case UNKNOWN:
                result = Result.UNKNOWN;
            }
        }

        return result;
    }
}
