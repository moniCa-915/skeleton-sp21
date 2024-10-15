package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable, V> implements Map61B<K, V>{

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;
        public BSTNode(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    BSTNode root;
    int treeSize = 0;

    public BSTMap(){
        root = null;
    }

    @Override
    public void clear() {
        root = null;
        treeSize = 0;
    }

    @Override
    public boolean containsKey(K key) {
        BSTNode foundNode = findNode(root, key);
        return foundNode != null;
    }

    private BSTNode findNode(BSTNode node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return findNode(node.right, key);
        }
        if (cmp < 0) {
            return findNode(node.left, key);
        }
        return node;
    }

    @Override
    public V get(K key) {
        return findValue(root, key);
    }

    private V findValue(BSTNode node, K key){
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return findValue(node.right, key);
        }
        if (cmp < 0) {
            return findValue(node.left, key);
        }
        return node.value;
    }

    @Override
    public int size() {
        return treeSize;
    }

    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
    }

    private BSTNode putHelper(BSTNode node, K key, V value){
        if (node == null) {
            treeSize += 1;
            return new BSTNode(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = putHelper(node.right, key, value);
        } else if (cmp < 0) {
            node.left = putHelper(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
