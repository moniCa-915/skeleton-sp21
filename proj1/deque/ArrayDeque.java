package deque;
//import java.util.Iterator;

public class ArrayDeque<Item> implements Deque<Item> {
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
//
//    public Iterator<Item> iterator(){
//        return new ArrayDequeIterator();
//    }
//
//    private class ArrayDequeIterator implements Iterator<Item>{
//        private int currentPos;
//        private int count;
//
//        public ArrayDequeIterator(){
//            currentPos = (nextFirst + 1) % items.length;
//            count = 0;
//        }
//        @Override
//        public boolean hasNext() {
//            return count < size;
//        }
//
//        @Override
//        public Item next() {
//            Item returnItem = items[currentPos];
//            currentPos = (currentPos + 1) % items.length;
//            count += 1;
//            return returnItem;
//        }
//    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof ArrayDeque<?>o1)) {
            return false;
        }
        if (o1.size() != this.size) {
            return false;
        }
        for (int i = 0; i < this.size; i ++){
            if (!this.get(i).equals(o1.get(i))){
                return false;
            }
        }
        return true;
    }


}
