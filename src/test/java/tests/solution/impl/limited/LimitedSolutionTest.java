package tests.solution.impl.limited;

import solution.LimitedSolution;
import task.MyList;
import task.Solution;
import tests.solution.AbstractSimpleTest;

public class LimitedSolutionTest extends AbstractSimpleTest {

    public LimitedSolutionTest(MyList list, boolean result) {
        super(list, result);
    }

    @Override
    protected Solution createSolution() {
        return new LimitedSolution();
    }
}

