public class LinkedListDeque<T> {

    private static class LinkedNode<T> {
        private T value;
        private LinkedNode<T> next;
        private LinkedNode<T> prev;

        LinkedNode(T val, LinkedNode next, LinkedNode prev) {
            this.value = val;
            this.next = next;
            this.prev = prev;
        }

        private T getRecursive(int index) {
            if (index == 0) {
                return value;
            }
            return next.getRecursive(index - 1);
        }
    }
    private int size;
    private LinkedNode<T> sentinel;
    public LinkedListDeque() {
        sentinel = new LinkedNode<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T val) {
        LinkedNode<T> node = new LinkedNode<>(val, sentinel.next, sentinel);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    public void addLast(T val) {
        LinkedNode<T> node = new LinkedNode<>(val, sentinel, sentinel.prev);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    public int size() {
        return size;
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return sentinel.next.getRecursive(index);


    }
    public T get(int index) {
        LinkedNode<T> ptr = sentinel;
        if (index < 0 || index >= size) {
            return null;
        }
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {
                ptr = ptr.next;
            }
        } else {
            for (int i = 0; i < size - index; i++) {
                ptr = ptr.prev;
            }
        }
        return ptr.value;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        LinkedNode<T> ptr = sentinel;
        for (int i = 0; i < size; i++) {
            ptr = ptr.next;
            System.out.print(ptr.value);
            System.out.print(' ');
        }
    }

    public T removeFirst() {
        if (size > 0) {
            LinkedNode<T> node = sentinel.next;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return node.value;
        } else {
            return null;
        }
    }

    public T removeLast() {
        if (size > 0) {
            LinkedNode<T> node = sentinel.prev;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return node.value;
        } else {
            return null;
        }
    }
}

