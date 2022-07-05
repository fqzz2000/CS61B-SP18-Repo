package synthesizer;

public interface BoundedQueue<T> {
    /* return size of the buffer */
    int capacity();
    /* return number of the items currently in the buffer */
    int fillCount();
    /* add item x in the end */
    void enqueue(T x);
    /* delete and return item from the front */
    T dequeue();
    /* return item from the front */
    T peek();
    /* return if the buffer is empty */
    default boolean isEmpty() {
        return fillCount() == 0;
    }
    /* return if the buffer is full */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
