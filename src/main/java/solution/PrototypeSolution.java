package solution;

import task.MyList;
import task.Solution;

/**
 * There is no normal error handling
 */
public class PrototypeSolution implements Solution {

    public boolean hasCycle(MyList list) {
        try {
            return hasCycleInternal(list);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception.", e);
        }
    }

    protected boolean hasCycleInternal(MyList list) throws Exception {

        if ( !list.hasNext() ) {
            return false;
        }
        Object currentValue = list.next();

        long index = 0;
        long maxCycleLength = 1;
        while ( list.hasNext() ) {
            Object next = list.next();
            if ( currentValue==null && next == null || currentValue!=null && currentValue.equals(next) ) {
                return true;
            }
            index++;
            if ( index>=maxCycleLength ) {
                currentValue = next;
                maxCycleLength = maxCycleLength*2;
                index = 0;
            }
        }
        return false;
    }
}
