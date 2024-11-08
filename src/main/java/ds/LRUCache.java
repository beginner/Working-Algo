package ds;

import java.util.HashMap;
import java.util.Map;

// Time -> O(1)
// Space -> O(capacity)
public class LRUCache {
    int capacity;
    CacheNode head, tail;
    Map<Integer, CacheNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new CacheNode(-1);
        tail = new CacheNode(-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        CacheNode node = map.get(key);
        removeNode(node);
        addAtHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode existingVal = map.get(key);
            removeNode(existingVal);
            addAtHead(existingVal);
            existingVal.val = value;
        } else {
            CacheNode newNode = new CacheNode(value);
            newNode.key = key;
            map.put(key, newNode);
            addAtHead(newNode);
            if (map.size() > capacity) {
                CacheNode toRemove = tail.prev;
                removeNode(toRemove);
                map.remove(toRemove.key);
            }
        }
    }

    private void removeNode(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addAtHead(CacheNode node) {
        CacheNode currentNext = head.next;

        node.next = currentNext;
        currentNext.prev = node;

        head.next = node;
        node.prev = head;
    }
}

class CacheNode {
    public int key;
    public int val;
    public CacheNode next, prev;
    public CacheNode(int val) {
        this.val = val;
    }
}