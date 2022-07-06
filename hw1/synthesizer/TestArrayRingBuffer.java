package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void enqueueTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount());
        arb.enqueue(10);
        assertEquals(1, arb.fillCount());
        assertEquals((Integer) 10, arb.peek());
        arb.enqueue(20);
        assertEquals((Integer) 10, arb.peek());
        assertEquals(2, arb.fillCount());
        assertEquals((Integer) 10, arb.dequeue());
        assertEquals((Integer) 20, arb.peek());
        assertEquals(1, arb.fillCount());
        arb.dequeue();
        assertEquals(0, arb.fillCount());
        arb.enqueue(10);
        assertEquals(1, arb.fillCount());
        assertEquals((Integer) 10, arb.peek());
        arb.enqueue(20);
        assertEquals((Integer) 10, arb.peek());
        assertEquals(2, arb.fillCount());
        assertEquals((Integer) 10, arb.dequeue());
        assertEquals((Integer) 20, arb.peek());
        assertEquals(1, arb.fillCount());
        arb.dequeue();
        assertEquals(0, arb.fillCount());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
