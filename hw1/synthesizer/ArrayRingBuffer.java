package synthesizer;


//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T>{
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
        }

        return val;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount > 0) {
            return rb[first];
        }
        return null;
    }
}
