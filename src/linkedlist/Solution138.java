package linkedlist;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


// 138. Copy List with Random Pointer
public class Solution138 {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> store = new HashMap<>();

        Node pre = new Node(0);
        Node now = pre;
        Node old = head;

        while (old != null) {
            now.next = new Node(old.val);
            now = now.next;
            // store
            store.put(old, now);
            old = old.next;
        }

        // now the 2nd linked list is constructed, add the random pointer.
        old = head;
        now = pre.next;
        while (old != null) {
            Node random = old.random;
            now.random = store.get(random);
            old = old.next;
            now = now.next;
        }

        return pre.next;
    }
}
