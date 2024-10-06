package deque;

public interface Deque<T> {
    public void addFirst(T x);
    public void addLast(T x);
    public default boolean isEmpty(){
        return this.size() == 0;
    }

    public T get(int index);
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
}
