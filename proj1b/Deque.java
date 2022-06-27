public interface Deque<T> {
    public void addFirst(T val);
    public void addLast(T val);
    public T removeFirst();
    public T removeLast();
    public int size();
    public T get(int indec);
    public boolean isEmpty();
    public void printDeque();



}
