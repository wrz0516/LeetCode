package HashTable;

import java.util.HashMap;

public class LRUCache {
    class DLinkedList{
        int key;
        int value;
        DLinkedList prev;
        DLinkedList next;

        public DLinkedList() {
        }
        public DLinkedList(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    HashMap<Integer,DLinkedList> map = new HashMap<>();
    int capacity;
    int size;
    DLinkedList head;
    DLinkedList tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size=0;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        DLinkedList node = map.get(key);
        if(node!=null){
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedList node = map.get(key);
        if(node==null){
            DLinkedList cur = new DLinkedList(key,value);
            addToHead(cur);
            map.put(key,cur);
            size++;
            if(size>capacity){
                DLinkedList last = removeTail();
                map.remove(last.key);
                size--;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }

    }

    public void removeNode(DLinkedList node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public DLinkedList removeTail(){
        DLinkedList last = tail.prev;
        removeNode(last);
        return last;
    }

    public void addToHead(DLinkedList node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    public void moveToHead(DLinkedList node){
        removeNode(node);
        addToHead(node);
    }
}
