package solution;

import task.MyList;

/**
 * LimitedSolution assumptions:
 * Number of elements less than 2^65-1
 * Length of cycle less than 2^64-1
 */
public class LimitedSolution extends AbstractSolution {

    @Override
    protected boolean hasCycleInternal(MyList list) {
        if ( !list.hasNext() ) {
            return false;
        }
        Object currentValue = getNext(list);
        if ( END_OF_LIST.equals(currentValue) ) {
            return false;
        }

        long iterator = 0;
        long maxCycleLength = 1;
        for ( Object next = getNext(list); next!=END_OF_LIST; next = getNext(list)) {
            if ( currentValue==null && next == null || currentValue!=null && currentValue.equals(next) ) {
                return true;
            }
            iterator++;
            if ( iterator>=maxCycleLength ) {
                if ( maxCycleLength == Long.MAX_VALUE ) {
                    throw new IndexOutOfBoundsException("Too long list for LimitedSolution. Try to use UnlimitedSolution.");
                }
                maxCycleLength = maxCycleLength*2;
                if ( maxCycleLength<iterator ) {
                    maxCycleLength = Long.MAX_VALUE;
                }
                currentValue = next;
                iterator = 0;
            }
        }

        return false;
    }
}
