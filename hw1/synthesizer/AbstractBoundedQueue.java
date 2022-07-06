package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int capacity;
    protected int fillCount;
    /* getter of capacity; return size of the buffer */
    @Override
    public int capacity() {
        return capacity;
    }
    /* getter of fillCount; return number of current items of the buffer*/
    @Override
    public int fillCount() {
        return fillCount;
    }



}
