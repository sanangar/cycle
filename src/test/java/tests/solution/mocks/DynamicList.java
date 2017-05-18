package tests.solution.mocks;

import task.MyList;

public class DynamicList implements MyList {

    private long beforeCycleLength;
    private long cycleLength;

    private long index = 0;

    public DynamicList(long beforeCycleLength, long cycleLength) {
        this.beforeCycleLength = beforeCycleLength;
        this.cycleLength = cycleLength;
    }

    public boolean hasNext() {
        return cycleLength > 0 || beforeCycleLength > 0;
    }

    public Object next() throws Exception {
        if ( beforeCycleLength>0 ) {
            beforeCycleLength--;
            return new Object();
        }

        if ( cycleLength == 0 ) {
            throw new ArrayIndexOutOfBoundsException("Check hasNext() before calling next().");
        }

        index = (index+1) % cycleLength;
        return (Long) index;
    }

    public String toString() {
        return "DynamicList{beforeCycleLength="+beforeCycleLength+", cycleLength="+cycleLength+"}";
    }
}
