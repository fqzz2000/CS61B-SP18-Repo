public interface Deque<T> {
    void addFirst(T val);
    void addLast(T val);
    T removeFirst();
    T removeLast();
    int size();
    T get(int indec);
    boolean isEmpty();
    void printDeque();



}
