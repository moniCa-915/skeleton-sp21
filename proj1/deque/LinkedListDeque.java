package deque;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{


    private class TNode {
        private TNode prev;
        private T item;
        private TNode next;

        private TNode(TNode p, T x, TNode n) {
            prev = p;
            item = x;
            next = n;
        }
    }

    //create an empty LinkedListDeque
    private TNode sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void addFirst(T x) {
        sentinel.next = new TNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T x) {
        sentinel.prev = new TNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public T get(int index) {
        TNode pointer = sentinel;
        for (int i = 0; i < index; i ++) {
            pointer = pointer.next;
        }
        return pointer.next.item;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode pointer = sentinel;
        for (int i = 0; i < size; i ++) {
            System.out.println(pointer.next.item);
            pointer = pointer.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next == sentinel && sentinel.prev == sentinel) {
            return null;
        }
        TNode nextFirst = sentinel.next.next;
        TNode returnItem = sentinel.next;
        sentinel.next = nextFirst;
        nextFirst.prev = sentinel;
        size -= 1;
        return returnItem.item;
    }

    public T removeLast() {
        if (sentinel.next == sentinel && sentinel.prev == sentinel) {
            return null;
        }
        TNode nextLast = sentinel.prev.prev;
        TNode returnNext = sentinel.prev;
        sentinel.prev = nextLast;
        nextLast.next = sentinel;
        size -= 1;
        return  returnNext.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    //helper method, to update new pointer
    private T getRecursiveHelper(int index, TNode pointer){
        if (index == 0) {
            return pointer.item;
        }
        return getRecursiveHelper(index - 1, pointer.next);
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        int currentPos;
        public LinkedListIterator(){
            currentPos = 0;
        }
        @Override
        public boolean hasNext() {
            return currentPos < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                TNode current = sentinel;
                for (int i = 0; i < currentPos; i ++) {
                    current = current.next;
                }
                currentPos += 1;
                return current.next.item;
            }
            return null;
        }
    }
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o instanceof LinkedListDeque oll){
            if (oll.size() != this.size) {
                return false;
            }
            TNode current = this.sentinel;
            TNode ollCurrent = oll.sentinel;
            while (current.next != this.sentinel) {
                current = current.next;
                ollCurrent = ollCurrent.next;
                if (!current.item.equals(ollCurrent.item)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
