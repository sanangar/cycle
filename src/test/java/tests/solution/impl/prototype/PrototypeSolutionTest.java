package tests.solution.impl.prototype;

import solution.PrototypeSolution;
import task.MyList;
import task.Solution;
import tests.solution.AbstractSimpleTest;

public class PrototypeSolutionTest extends AbstractSimpleTest {

    public PrototypeSolutionTest(MyList list, boolean result) {
        super(list, result);
    }

    @Override
    protected Solution createSolution() {
        return new PrototypeSolution();
    }
}
