// LRU cache

import java.util.HashMap;
import java.util.Map;


class Entry {
    int key;
    int value;
    Entry prev;
    Entry next;

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class BiDirectionQueue {

    Entry head;
    Entry tail;
    private int size;

    public BiDirectionQueue() {
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(Entry ent) {
        // add to the tail
        ent.next = tail;
        ent.prev = tail.prev;
        tail.prev.next = ent;
        tail.prev = ent;
        size++;
    }

    public void push(Entry ent) {
        // add to head
        ent.prev = head;
        ent.next = head.next;
        head.next.prev = ent;
        head.next = ent;
        size++;
    }

    public void remove(Entry ent) {
        // remove an Entry in the queue
        Entry prev = ent.prev;
        Entry next = ent.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    public Entry poll() {
        // getting an Entry from the tail, and remove it
        if (head.next == tail) return null;
        Entry res = tail.prev;
        remove(tail.prev);
        return res;
    }

    public Entry pop() {
        // getting an Entry from the head, and remove it
        if (head.next == tail) return null;
        Entry res = head.next;
        remove(res);
        return res;
    }

    public int size() {return size;}

}


class LRUCache {

    int capacity;
    Map<Integer, Entry> map = new HashMap<>();
    BiDirectionQueue cache = new BiDirectionQueue();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Entry ent = map.get(key);
            cache.remove(ent);
            cache.push(ent);
            return ent.value;
        }
    }

    public void put(int key, int value) {
        Entry ent = new Entry(key, value);
        if (map.containsKey(key)) {
            Entry old = map.get(key);
            cache.remove(old);
        } else if (cache.size() == capacity) {
            Entry last = cache.poll();
            map.remove(last.key);
        }
        cache.push(ent);
        map.put(key, ent);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Solution27 {

    public static void main(String[] args) {
        // ["LRUCache","put","put","get","put","put","get"]
        // [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(2, 2);
        int shit = obj.get(2);
        obj.put(1, 1);
        obj.put(4, 1);
        int shit2 = obj.get(2);
    }
}
