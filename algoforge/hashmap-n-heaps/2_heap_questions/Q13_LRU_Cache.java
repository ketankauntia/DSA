// https://leetcode.com/problems/lru-cache/

import java.util.*;
class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    HashMap<Integer, Node> cache;
    int cap;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if(node ==null){
            return -1;
        } else{
            int v1 = node.value;
            moveToFront(node);
            return v1;
        }
        
    }
    
    public void put(int key, int value) {
        
        Node node = cache.get(key);
        
        if(node == null){   // if pair does not exist,
            //first we check capacity.
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if(cache.size()==cap){  // cap full -> remove last, make new node, add node, update hashmap
                Node last_node = tail.prev;
                cache.remove(last_node.key);
                removeNode(last_node);
            }
            cache.put(key, newNode);
            addNode(newNode);

        } else{ //pair exists -> update node value, move to front
            node.value = value;
            moveToFront(node);  //made recently used.
        }
    }

    private void addNode(Node node){
        Node nbr = head.next;   // neighbour node to right

        //curr node links to prev & next nodes.
        node.next = nbr;
        node.prev = head;

        // prev & front nodes link back to the curr node
        head.next = node;
        nbr.prev = node;
    }

    private void removeNode(Node node){
        Node prevN = node.prev; // previous Node
        Node nextN = node.next; // next Node
        
        prevN.next = nextN;
        nextN.prev = prevN;

        //unlinked the current node from prev & next
        node.prev = null;   
        node.next = null;
    }

    private void moveToFront(Node node){
        removeNode(node);   // removed node from the cache
        addNode(node);      // added node to the cache, now position changes and updates to latest
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 public class Q13_LRU_Cache {
    
}
