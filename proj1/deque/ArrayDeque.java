package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        items = (Item [])new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }
    //helper method to adjust the array length to increase the time efficiency
    private void resize(int capacity) {
        Item[] newArrayDeque = (Item [])new Object[capacity];
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i ++) {
            newArrayDeque[i] = items[current];
            current = (current + 1) % items.length;
        }
        items = newArrayDeque;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(Item i) {
        if (size == items.length) {
            resize(items.length * 2); //if size more than half of items.length -> resize ArrayDeque
        }
        items[nextFirst] = i;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }
    public void addLast(Item i) {
        if (size == items.length) {
            resize(items.length * 2); //if size more than half of items.length -> resize ArrayDeque
        }
        items[nextLast] = i;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    public boolean isEmpty(){
        return (nextFirst + 1) % items.length == nextLast;
    }

    public Item removeFirst(){
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        Item removedItem = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if (size > 8 && size <= (items.length / 4)) {
            resize(items.length / 2);
        }
        return removedItem;
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        Item removedItem = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (size > 8 && size <= (items.length / 4)) {
            resize(items.length / 2);
        }
        return removedItem;
    }

    public int size(){
        return size;
    }

    public Item get(int index) {
        int position = (nextFirst + index + 1) % items.length;
        return items[position];
    }

    public void printDeque() {
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i ++) {
            System.out.print(items[current] + " ");
            current = (current + 1) % items.length;
        }
        System.out.println();
    }

}
