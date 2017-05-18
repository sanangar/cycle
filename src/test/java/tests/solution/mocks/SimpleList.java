package tests.solution.mocks;

import task.MyList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleList implements MyList {

    private final List list;
    private final int indexOfCycleStart;

    private int index = 0;

    public SimpleList(int indexOfCycleStart, Object ... args) {
        list = Arrays.asList(args);
        this.indexOfCycleStart = indexOfCycleStart;
    }

    public boolean hasNext() {
        if ( indexOfCycleStart<0 && index>=list.size() ) {
            return false;
        }
        return true;
    }

    public Object next() throws Exception {
        if ( index>=list.size() ) {
            if ( indexOfCycleStart<0 ) {
                throw new ArrayIndexOutOfBoundsException("Check hasNext() before calling next().");
            } else {
                index = indexOfCycleStart;
            }
        }
        return list.get(index++);
    }

    public String toString() {
        return "SimpleList{cycleIndex="+indexOfCycleStart+", "+list+"}";
    }
}
