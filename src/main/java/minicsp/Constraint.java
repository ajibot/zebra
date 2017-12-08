package minicsp;

import java.util.Set;

public interface Constraint {

    void buildVariables(Set<IntVar> variables);

    Result isSatisfied();
}
