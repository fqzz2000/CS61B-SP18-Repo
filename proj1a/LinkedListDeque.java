public class LinkedListDeque<DataType> {

    private static class LinkedNode<DataType> {
        public DataType value;
        public LinkedNode<DataType> next;
        public LinkedNode<DataType> prev;

        public LinkedNode(DataType val, LinkedNode next, LinkedNode prev){
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
    }
    private int size;
    private LinkedNode<DataType> sentinel;
    public LinkedListDeque(){
        sentinel = new LinkedNode<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public void addFirst(DataType val){
        LinkedNode<DataType> node = new LinkedNode<>(val, sentinel.next, sentinel);
        sentinel.next = node;
        size += 1;
    }

    public void addLast(DataType val){
        LinkedNode<DataType> node = new LinkedNode<>(val, sentinel, sentinel.prev);
        sentinel.prev = node;
        size -= 1;
    }

    public int size(){
        return size;
    }

    public DataType get(int index){
        return null;
    }

    public boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    public void printDeque(){
        ;
    }

    public void removeFirst(){
        ;
    }

    public void removeLast(){
        ;
    }
}