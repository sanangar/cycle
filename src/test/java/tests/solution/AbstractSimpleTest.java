package tests.solution;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task.MyList;
import task.Solution;
import tests.solution.mocks.DynamicList;
import tests.solution.mocks.SimpleList;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TestCases
 */
@RunWith(value = Parameterized.class)
public abstract class AbstractSimpleTest {

    /*
    0 - number of elements before cycle starts
    1 - length of cycle
    2 - expected result (cycleLength=0 == (there is no cycle))
     */
    @Parameterized.Parameters(name = "{0}.hasCycle() =? {1}")
    public static Collection<Object[]> parameters() {
        long[] array = new long[]{0,1,2,5,1000,1000*1000};
        Collection<Object[]> parameters = new ArrayList<Object[]>(array.length * array.length);
        for ( int i=0; i<array.length; i++ ) {
            for ( int j=0; j<array.length; j++ ) {
                parameters.add(new Object[]{new DynamicList(array[i], array[j]), array[j]>0});
            }
        }
        parameters.add(new Object[]{new SimpleList(-1, "a", "b", "c"), false});
        parameters.add(new Object[]{new SimpleList(0, "a", "b", "c"), true});
        parameters.add(new Object[]{new SimpleList(1, "a", "b", "c"), true});

        parameters.add(new Object[]{new SimpleList(-1, null, "b", "c"), false});
        parameters.add(new Object[]{new SimpleList(-1, "a", null, "c"), false});
        parameters.add(new Object[]{new SimpleList(-1, "a", "b", null), false});

        parameters.add(new Object[]{new SimpleList(1, null, "b", "c"), true});
        parameters.add(new Object[]{new SimpleList(1, "a", null, "c"), true});
        parameters.add(new Object[]{new SimpleList(1, "a", "b", null), true});


        parameters.add(new Object[]{new SimpleList(1, "a", null), true});
        return parameters;
    }

    private MyList list;
    private boolean result;

    public AbstractSimpleTest(MyList list, boolean result) {
        this.list = list;
        this.result = result;
    }

    abstract protected Solution createSolution();

    @Test(timeout = 1000)
    public void test() {
        Assert.assertTrue(result == createSolution().hasCycle(list));
    }

}
