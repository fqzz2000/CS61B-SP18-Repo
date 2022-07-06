package synthesizer;
import org.junit.Test;

import java.awt.desktop.SystemEventListener;

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
        arb.peek();

    }

    @Test
    public void iteratorTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        System.out.println(arb.iterator().hasNext());

        int count = 0;
        for (int item : arb) {
            System.out.println(item);
            assertEquals(count, item);
            count += 1;
        }
        int countInner = 0;
        int countOuter = 0;
        for (int x : arb) {
            for (int y : arb) {
                assertEquals(countInner, y);
                assertEquals(countOuter, x);
                countInner += 1;
                countInner %= 10;
                System.out.println("x :" + x + " y : " + y);
            }
            countOuter += 1;
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
