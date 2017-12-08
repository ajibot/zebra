package minicsp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solver {
    private final Model model;
    private final List<IntVar> variables;
    private int variableIndex = 0;

    public Solver(final Model model) {
        this.model = model;
        variables = getVariables(model);
    }

    public boolean solve() {
        while (true) {
            final Result res = model.isSatisfied();
            if (res == Result.YES) {
                return true;
            }

            if (res == Result.NO) {
                variableIndex--;
            }

            if (variableIndex < 0) {
                return false;
            }

            step();
        }
    }

    private void step() {
        if (variableIndex >= variables.size()) {
            variableIndex--;
            return;
        }

        final IntVar variable = variables.get(variableIndex);
        if (!variable.isSet()) {
            variable.setValue(variable.getLowerBound());
            variableIndex++;
            return;
        }

        final int val = variable.getValue() + 1;
        if (val > variable.getUpperBound()) {
            variable.clearValue();
            variableIndex--;
            return;
        }

        variable.setValue(val);
        variableIndex++;
    }

    private static List<IntVar> getVariables(final Model model) {
        final Set<IntVar> variables = new LinkedHashSet<>();

        for (final Constraint c : model.getConstraints()) {
            c.buildVariables(variables);
        }

        return new ArrayList<>(variables);
    }
}
