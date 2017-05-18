package solution;

import task.MyList;
import task.Solution;

public abstract class AbstractSolution implements Solution {

    protected static Object END_OF_LIST = new Object();

    public boolean hasCycle(MyList list) {
        if ( list == null ) {
            throw new IllegalArgumentException("List is null.");
        }
        try {
            return hasCycleInternal(list);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Unexpected exception", ex);
        }
    }

    abstract protected boolean hasCycleInternal(MyList list);

    protected Object getNext(MyList list) {
        try {
            return list.hasNext() ? list.next() : END_OF_LIST;
        } catch (Exception ex) {
            throw new RuntimeException("Can't get next element.", ex);
        }
    }

}
