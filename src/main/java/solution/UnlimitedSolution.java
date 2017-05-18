package solution;

import task.MyList;

/**
Limited by ~ 8^(2^32) elements
 */
public class UnlimitedSolution extends AbstractSolution {

    @Override
    protected boolean hasCycleInternal(MyList list) {
        if ( !list.hasNext() ) {
            return false;
        }
        Object currentValue = getNext(list);
        if ( END_OF_LIST.equals(currentValue) ) {
            return false;
        }

        Index index = new Index();
        for ( Object next = getNext(list); next!=END_OF_LIST; next = getNext(list)) {
            if ( currentValue==null && next == null || currentValue!=null && currentValue.equals(next) ) {
                return true;
            }
            if ( index.increment() ) {
                currentValue = next;
            }
        }

        return false;
    }

    class Index {

        private byte[] array;

        public Index() {
            array = new byte[]{0};
        }

        /*
        return true if index was expand;
         */
        public boolean increment() {
            for ( int i=0; i<array.length; i++ ) {
                if ( array[i] == Byte.MAX_VALUE ) {
                    array[i]=0;
                } else {
                    array[i]++;
                    return false;
                }
            }
            array = new byte[array.length+1];
            return true;
        }
    }
}