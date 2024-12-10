package linkedlist;

// 23. Merge k Sorted Lists
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode pre = new ListNode();
        ListNode now = pre;
        int index;
        boolean cond = true;

        while (cond) {
            index = -1;
            cond = false;
            // find the smallest element
            int min = Integer.MAX_VALUE;
            for (int i=0; i<lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    cond = true;
                    if (node.val < min) {
                        min = node.val;
                        index = i;
                    }
                }
            }
            // do the actual update
            if (index != -1) {
                ListNode smallest = lists[index];
                now.next = smallest;
                now = now.next;
                lists[index] = smallest.next;
            }
        }

        return pre.next;
    }
}
