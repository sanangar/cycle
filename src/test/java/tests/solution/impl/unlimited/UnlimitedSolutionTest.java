package tests.solution.impl.unlimited;

import solution.UnlimitedSolution;
import task.MyList;
import task.Solution;
import tests.solution.AbstractSimpleTest;

public class UnlimitedSolutionTest extends AbstractSimpleTest {

    public UnlimitedSolutionTest(MyList list, boolean result) {
        super(list, result);
    }

    @Override
    protected Solution createSolution() {
        return new UnlimitedSolution();
    }
}

