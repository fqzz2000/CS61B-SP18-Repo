public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int ptrStart;
    private int ptrEnd;

    ArrayDeque() {
        items = (T []) new Object[8];
        capacity = 8;
        size = 0;
        ptrStart = 0;
        ptrEnd = 0;
    }
    private void resizeToGivenLength(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        if (ptrStart > ptrEnd) {
            System.arraycopy(items, ptrStart, newItems, 0, capacity - ptrStart);
            System.arraycopy(items, 0, newItems, capacity - ptrStart, ptrEnd + 1);
        } else {
            System.arraycopy(items, ptrStart, newItems, 0, size);
        }
        items = newItems;
        ptrStart = 0;
        ptrEnd = size - 1;
        capacity = newCapacity;
    }
    private void updateSizeIfNeeded() {
        if (size == capacity) {
            resizeToGivenLength(capacity * 2);
        } else if (capacity > 16 && ((float) size) / capacity < 0.25) {
            resizeToGivenLength(capacity / 2);
        }
    }
    public void addFirst(T val) {
        updateSizeIfNeeded();
        if (size != 0) {
            ptrStart = ptrStart != 0 ? ptrStart - 1 : ptrStart + capacity - 1;
        }
        items[ptrStart] = val;
        size += 1;
    }

    public void addLast(T val) {
        updateSizeIfNeeded();
        if (size != 0) {
            ptrEnd = ptrEnd != capacity - 1 ? ptrEnd + 1 : ptrEnd - capacity + 1;
        }
        items[ptrEnd] = val;
        size += 1;
    }

    public boolean isEmpty() {

        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = ptrStart; i < size + ptrStart; i++) {
            System.out.print(items[i < capacity ? i : i - capacity]);
            System.out.print(' ');
        }
        System.out.println();
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        index = index + ptrStart;
        index = index < capacity ? index : index - capacity;
        return items[index];
    }
    public T removeFirst() {
        T node = items[ptrStart];
        ptrStart = ptrStart + 1 != capacity ? ptrStart + 1 : 0;
        size -= 1;
        updateSizeIfNeeded();
        return node;
    }

    public T removeLast() {
        T node = items[ptrEnd];
        ptrEnd = ptrEnd - 1 != -1 ? ptrEnd - 1 : ptrEnd + capacity - 1;
        size -= 1;
        updateSizeIfNeeded();
        return node;
    }
}
