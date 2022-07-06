package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        fillCount = 0;
        first = 0;
        last = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    public void enqueue(T x) {
        if (fillCount < capacity) {
            rb[last] = x;
            last += 1;
            last %= capacity;
            fillCount += 1;
        } else {
            throw new RuntimeException("Ring Buffer Overflow");
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        T val = null;
        if (fillCount > 0) {
            val = rb[first];
            first += 1;
            first %= capacity;
            fillCount -= 1;
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        return val;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount > 0) {
            return rb[first];
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return null;
    }
    public Iterator<T> iterator() {
        return new ArrayRingIterator();
    }

    private class ArrayRingIterator implements  Iterator<T> {
        private int pointer;
        private int counter;
        public ArrayRingIterator() {
            pointer = first;
        }
        public boolean hasNext() {
            if (counter == fillCount) {
                return false;
            }
            return true;
        }

        public T next() {
            T val = rb[pointer];
            pointer += 1;
            pointer %= capacity;
            counter += 1;
            return val;
        }

    }
}
